import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static TreeSet<String> emailsTreeSet = new TreeSet<>() {{
        add("kostya@gmail.com");
        add("qwer123@yandex.ru");
        add("sobaka@mail.ru");
    }};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду: ");
            String input = scanner.nextLine();
            String splitCommand[] = input.split("\\s", 2);

            switch (splitCommand[0].toLowerCase()) {
                case "list":
                    printEmails();
                    break;

                case "add":
                    if (splitCommand.length < 2) {
                        System.out.println("Не введен email");
                        break;
                    }
                    String mail = input.replaceAll("(add)\\s+", "");
                    if (mail.matches("[^@]+@[^\\.\\,]+\\..+"))
                        addEmail(mail);
                    else System.out.println("Неправильный email");
                    break;

                    default:
                            continue;

                    }


            }
        }

        public static void addEmail (String email){
            if (!email.matches(".+@.+\\.(com|ru)")) {
                System.out.println("Не правильно введен email");
                return;
            } else emailsTreeSet.add(email);
        }

        public static void printEmails () {
            for (String item : emailsTreeSet) {
                System.out.println(item);
            }
        }


    }
