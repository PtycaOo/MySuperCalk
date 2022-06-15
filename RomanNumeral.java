package CalcTest1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static CalcTest1.Main.cl;

public enum RomanNumeral {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100);

    private final int value;

    RomanNumeral(int value) {
        this.value = value;

    }

    public int getValue() {
        return value;
    }

    public static List getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                .collect(Collectors.toList());
    }

    public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = (RomanNumeral) romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }


        return result;
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 100)) {
            throw new IllegalArgumentException("В римской системе счисления нет отрицательных чисел :(");

        }

        List romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = (RomanNumeral) romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
    public static String calcRoman(String a, String b, String c) throws Exception {
        int a1 = RomanNumeral.romanToArabic(a);
        int b1 = RomanNumeral.romanToArabic(b);
        if (a1 >= 11 || b1 >=11){
            throw new Exception("Введите число от 1 до 10 включительно");
        }else {
            int result = cl.sum(a1, b1, c);
            return RomanNumeral.arabicToRoman(result);
        }
    }

}
