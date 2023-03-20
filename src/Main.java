import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArabicRome helper = new ArabicRome();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение с двумя числами");
        String str = scanner.nextLine();
        str = str.replace(" ", "");
        String[] allowed_operations = {"+", "-", "/", "*"};

        for (String action : allowed_operations) {
            if (str.contains(action)) {
                String[] numbers = str.split("[" + action + "]");
                String a = numbers[0];
                String b = numbers[1];

                if (helper.isArabic(a) && !helper.isArabic(b) ){
                    System.out.println("Одно из чисел арабское, а другое римское!\nТак нельзя");
                    return;
                }

                boolean return_romanian = helper.isArabic(a) && helper.isArabic(b);

                a = helper.RomanianToArabic(a);
                b = helper.RomanianToArabic(b);

                int a_int = Integer.parseInt(a);
                int b_int = Integer.parseInt(b);

                if ( !(a_int >= 0 && a_int <= 10) && !(b_int >= 0 && b_int <= 10)){
                    System.out.println("Оба числа должны быть в диапазоне от 0 до 10!");
                    return;
                }

                int answer = 0;
                switch (action) {
                    case "+":
                        answer = a_int + b_int;
                        break;
                    case "-":
                        answer = a_int - b_int;
                        break;
                    case "*":
                        answer = a_int * b_int;
                        break;
                    case "/":
                        try {
                            answer = a_int / b_int;
                        } catch (ArithmeticException e) {
                            System.out.println("Нельзя делить на ноль");
                            return;
                        }
                        break;
                    default:
                        break;
                }

                if (return_romanian){
                    String answer_string = helper.ArabicToRomanian(answer);
                    System.out.println(answer_string);
                    return;
                }
                System.out.println(answer);
            }

        }
    }
}