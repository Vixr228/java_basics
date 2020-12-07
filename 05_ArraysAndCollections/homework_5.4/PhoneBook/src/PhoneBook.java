import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBook {

    private static TreeMap<String, String> phoneBook = new TreeMap<>(){{
        put("Андрей", "+79994123258");
        put("Костя", "89994410260");
        put("Анатолий", "79135349752");
    }};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true){
            String input = scanner.nextLine();
            String temp = "";
            String command = "";
            if(input.matches("\\+?\\d{11}")) command = "number";
            if(input.matches("[А-Яа-яёЁ]+")) command = "name";
            if(input.equals("LIST") || input.equals("list")) command = "list";

            switch (command){
                case "number":
                    if(phoneBook.containsValue(input))
                        printPersonWithNumber(input);
                    else {
                        System.out.println("Введите имя: ");
                        temp = scanner.nextLine();
                        phoneBook.put(temp, input);
                    }
                    break;
                case "name":
                    if(phoneBook.containsKey(input))
                        printPersonWithName(input);
                    else {
                        System.out.println("Введите номер: ");
                        temp = scanner.nextLine();
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

    private static void printPersonWithNumber(String value){
        for(String name : phoneBook.keySet()){
            if(phoneBook.get(name).equals(value)) {
                System.out.println(name + " : " + phoneBook.get(name));
                break;
            }
        }
    }
    private static void printPersonWithName(String name){
        System.out.println(name + " : " + phoneBook.get(name));
    }
    private static void printPhoneBook(){
        for(String key : phoneBook.keySet()){
            System.out.println(key + " : " + phoneBook.get(key));
        }
    }
}
