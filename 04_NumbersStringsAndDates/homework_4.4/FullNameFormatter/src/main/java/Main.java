import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String name = " ";
        String surname = " ";
        String fatherName = " ";


        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            boolean checkFlag = true;
            //Проверка на кирилицу
            for (int i = 0; i < input.length(); i++) {
                if ((input.charAt(i) > 1040 && input.charAt(i) < 1104) || input.charAt(i) == '-' || input.charAt(i) == ' ')
                    continue;
                else checkFlag = false;

            }

            //проверка на три слова
            int spaceCount = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ') spaceCount++;
            }
            if (spaceCount != 2) checkFlag = false;

            //Следущая попытка
            if(!checkFlag) {
                System.out.println("Введенная строка не является ФИО");
                continue;
            }


            surname = input.substring(0, input.indexOf(' '));
            name = input.substring(input.indexOf(' '), input.lastIndexOf(' '));
            fatherName = input.substring(input.lastIndexOf(' '), input.length());


            System.out.println("Фамилия: " + surname.trim());
            System.out.println("Имя: " + name.trim());
            System.out.println("Отчество: " + fatherName.trim());
        }


    }


}