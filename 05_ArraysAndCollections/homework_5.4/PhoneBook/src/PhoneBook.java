import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBook {

    private static TreeMap<String, String> phoneBook = new TreeMap<>() {{
        put("Андрей", "79994123258");
        put("Костя", "79994410260");
        put("Анатолий", "79135349752");
    }};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String temp = "";
            String command = "";


            if (input.matches("[А-Яа-яёЁ]+")) command = "name";
            if (input.equals("LIST") || input.equals("list")) command = "list";
            if (phoneValidation(input)) command = "number";



            switch (command) {
                case "number":
                    String valid = phoneSameValidation(input);
                    if (valid.equals("Неверный формат номера")) {
                        System.out.println(valid);
                        break;
                    }
                    else input = valid;
                    System.out.println("INPUT: " + input);
                    if (phoneBook.containsValue(input))
                        printPersonWithNumber(input);
                    else {
                        System.out.println("Введите имя: ");
                        temp = scanner.nextLine();
                        phoneBook.put(temp, input);
                    }
                    break;
                case "name":
                    if (phoneBook.containsKey(input))
                        printPersonWithName(input);
                    else {
                        System.out.println("Введите номер: ");
                        temp = scanner.nextLine();
                        valid = phoneSameValidation(temp);
                        if (valid.equals("Неверный формат номера")) {
                            System.out.println(valid);
                            break;
                        }
                        else temp = valid;
                        phoneBook.put(input, temp);
                    }
                    break;
                case "list":
                    printPhoneBook();
                    break;
                default:
                    continue;
            }
        }
    }

    private static void printPersonWithNumber(String value) {
        for (String name : phoneBook.keySet()) {
            if (phoneBook.get(name).equals(value)) {
                System.out.println(name + " : " + phoneBook.get(name));
                break;
            }
        }
    }

    private static void printPersonWithName(String name) {
        System.out.println(name + " : " + phoneBook.get(name));
    }

    private static void printPhoneBook() {
        for (String key : phoneBook.keySet()) {
            System.out.println(key + " : " + phoneBook.get(key));
        }
    }
    private static boolean phoneValidation (String phone) {
        if (phone.matches(".*((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}.*")) return true;
        else return false;
    }
    private static String phoneSameValidation(String phone) {

        if (phone.matches(".*((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}.*")) {
            String phoneNum = phone.replaceAll("[^0-9]", "");
            if ((phone.replaceAll("[^0-9]", "").length() == 11
                    && (phone.replaceAll("[^0-9]", "").charAt(0) == '8'
                    || phone.replaceAll("[^0-9]", "").charAt(0) == '7'))) {
                return phoneNum.charAt(0) == '8' ? ("7" + phoneNum.substring(1, 11)) : (phoneNum);
            } else if (phone.replaceAll("[^0-9]", "").length() == 10) {
                return "7" + phoneNum;
            } else
                return "Неверный формат номера";
        } else
            return "Неверный формат номера";

    }
}
