import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static ArrayList<String> todoList = new ArrayList<>(){{
        add("Дело номер один");
        add("Дело номер два");
        add("Дело номер три");
    }};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду: ");
            String input = scanner.nextLine();
            String[] splitCommand = input.split("\\s", 3);

            if(splitCommand.length > 1 && splitCommand[1].matches("\\d+")) splitCommand[0] += "!";
            /*
                splitCommand[0] - Команда
                splitCommand[1] - Индекс (если есть), если нет, то текст
                splitCommand[2] - Текст
             */
            switch (splitCommand[0]){
                case "ADD":
                    simpleAddToList(input.substring(input.indexOf(' ')));
                    break;
                case "ADD!":
                    atIndexAddToList(splitCommand[2], splitCommand[1]);
                    break;
                case "EDIT!":
                    editList(splitCommand[2], splitCommand[1]);
                    break;
                case "LIST":
                    printList();
                    break;
                case "DELETE!":
                    removeFromList(splitCommand[1]);
                default: continue;
            }

        }
    }

    public static void simpleAddToList(String input){
        todoList.add(input.trim());
    }

    public static void atIndexAddToList(String input, String strIndex){
        int index = Integer.parseInt(strIndex);
        if(index <= todoList.size())
            todoList.add(index, input.trim());
        else System.out.println("Нельзя поместить элемент на эту позицию");
    }

    public static void editList (String input, String strIndex){
        int index = Integer.parseInt(strIndex);
        if(index <= todoList.size() - 1) {
            todoList.remove(index);
            todoList.add(index, input);
        }
        else System.out.println("Нет такого элемента");
    }

    public static void printList() {
        System.out.println("Список дела: ");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(i + " - " + todoList.get(i));
        }
    }
    public static void removeFromList(String strIndex){
        int index = Integer.parseInt(strIndex.trim());
        if(index <= todoList.size() - 1)
            todoList.remove(index);
        else System.out.println("Нет такого элемента");
    }
}
