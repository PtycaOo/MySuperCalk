package CalcTest1;

public class useAns {
    int ans;

    int sum(int a,int b, String c){
        switch (c){
            case "+":
                ans = a + b;
                break;
            case "-":
                ans = a - b;
                break;
            case "/":
                ans = a / b;
                break;
            case "*":
                ans = a * b;
            default:
                System.out.println("Введен не кооректный символ");
        }

        return ans;
    }
}
