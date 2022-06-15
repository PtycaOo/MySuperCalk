package CalcTest1;

import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static useAns cl = new useAns();

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение:");
        String res = calc(sc.nextLine());
        System.out.println(res);
    }

    public static String calc(String input) throws Exception {
            String[] strings;
            strings = input.split(" ");
            if (strings.length > 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два "
                    + "операнда и один оператор (+, -, /, *)");
            } else {

            boolean qwe = isDigit(strings[0]);
            boolean ewq = isDigit(strings[2]);
            if ((qwe && ewq)) {
                int num1 = Integer.parseInt(strings[0]);
                int num2 = Integer.parseInt(strings[2]);
                if (num1 < 0 || num1 > 10 && num2 < 0 || num2 > 10) {
                    throw new Exception("Введите число от 1 до 10 включительно");
                } else {
                    int result = cl.sum(num1, num2, strings[1]);
                    return String.valueOf(result);
                }
            } else if ((qwe || ewq)) {
                throw new Exception("Используются разные системы счисления");
            }
            return RomanNumeral.calcRoman(strings[0], strings[2], strings[1]);
        }
    }

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }


    }
}
