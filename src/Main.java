import java.io.IOException;
import java.util.Scanner;
import java.lang.NumberFormatException;
public class Main {
    public static void main(String[] args) {
        ArabicRome helper = new ArabicRome();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение с двумя числами");
        String str = scanner.nextLine();
        str = str.replace(" ", "");
        String[] allowed_operations = {"+", "-", "/", "*"};

        for (String action : allowed_operations) {
            if (!str.contains(action)){
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Вы не ввели нужное действие между числами!");
                    return;
                }
            }
            else {
                String[] numbers = str.split("[" + action + "]");
                if (numbers.length != 2){
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Нужно ввести два числа и действие между ними!");
                        return;
                    }
                }

                String a = numbers[0];
                String b = numbers[1];

                if (helper.isArabic(a) != helper.isArabic(b) ){
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Одно из чисел арабское, а другое римское!\nТак нельзя");
                        return;
                    }
                }

                boolean return_romanian = helper.isArabic(a) && helper.isArabic(b);

                a = helper.RomanianToArabic(a);
                b = helper.RomanianToArabic(b);
                int a_int, b_int;
                try {
                    a_int = Integer.parseInt(a);
                    b_int = Integer.parseInt(b);
                } catch (NumberFormatException e) {
                    System.out.println("Прописано неподходящее число");
                    return;
                }

                if ( !(a_int >= 0 && a_int <= 10) && !(b_int >= 0 && b_int <= 10)){
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Оба числа должны быть в диапазоне от 0 до 10!");
                        return;
                    }
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
                return;
            }

        }
    }
}