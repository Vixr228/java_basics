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
            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
            if(!input.matches("[а-яёА-ЯЁ\\-\\s]+")) {
                System.out.println("Введенная строка не является ФИО");
                continue;
            }
            String fio[] = input.split("\\s+", 3);
            System.out.println("Фамилия: " + fio[0]);
            System.out.println("Имя: " + fio[1]);
            System.out.println("Отчество: " + fio[2]);

        //TODO Одно слово когда, то не работает
        }
    }

}