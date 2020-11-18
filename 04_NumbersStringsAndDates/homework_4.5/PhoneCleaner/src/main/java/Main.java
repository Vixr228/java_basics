import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO:напишите ваш код тут, результат вывести в консоль.
            //if(input.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {


            String number = input.replaceAll("[\\+\\-()\\s]", "");
            if(!number.matches("(^(8|7)\\d{10}|^9\\d{9})")){
                System.out.println("Неверный формат номера");
                continue;
            }
            if(number.matches("^8\\d{10}")) number = number.replaceFirst("8", "7");
            if(number.matches("^9\\d{9}")) System.out.println("7" + number);
            else System.out.println(number);


        }
    }

}
