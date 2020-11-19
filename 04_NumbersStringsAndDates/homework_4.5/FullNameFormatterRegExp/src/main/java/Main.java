import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ\\-]+\\s[а-яёА-ЯЁ\\-]+\\s[а-яёА-ЯЁ\\-]+$");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            Matcher matcher = pattern.matcher(input);
            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
            //if(!input.matches("[а-яёА-ЯЁ\\-]+\\s[а-яёА-ЯЁ\\-]+\\s[а-яёА-ЯЁ\\-]+")) {
            if(!matcher.find()){
                System.out.println("Введенная строка не является ФИО");
                continue;
            }
            String fio[] = input.split("\\s", 3);
//            if(fio.length < 3) {
//                System.out.println("Введенная строка не является ФИО");
//                continue;
//            }
            System.out.println("Фамилия: " + fio[0]);
            System.out.println("Имя: " + fio[1]);
            System.out.println("Отчество: " + fio[2]);
            //done

        }
    }

}