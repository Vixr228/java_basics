import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> todoList = new ArrayList<>(){{
            add("Дело номер один");
            add("Дело номер два");
            add("Дело номер три");
        }};
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("EXIT")) {
                break;
            }
            if (input.matches("LIST")) {
                list(todoList);
            }
            if (input.matches("ADD\\s.+")) {
                if(input.matches("ADD\\s\\d+.+")){
                    todoList = addPos(input, todoList);
                }
                else todoList = add(input, todoList);
            }
            if(input.matches("DELETE\\s\\d+")){
                todoList = delete(input, todoList);
            }
            if(input.matches("EDIT\\s\\d+.+")){
                todoList = edit(input, todoList);
            }

        }


    }
    public static ArrayList<String> edit (String input, ArrayList<String> arrayList){
        String noEdit = input.substring(input.indexOf(' ')).trim();
        String intPos = noEdit.substring(0, noEdit.indexOf(' '));
        String item = noEdit.substring(noEdit.indexOf(' ')).trim();
        int position = Integer.parseInt(intPos.trim());
        if(position <= arrayList.size() - 1) {
            arrayList.remove(position);
            arrayList.add(position, item);
        }
        else System.out.println("Нет такого элемента");
        return arrayList;
    }

    public static ArrayList<String> delete (String input, ArrayList<String> arrayList){
        String positionStr = input.substring(input.indexOf(' '));
        int position = Integer.parseInt(positionStr.trim());
        if(position <= arrayList.size() - 1)
            arrayList.remove(position);
        else System.out.println("Нет такого элемента");
        return arrayList;
    }

    public static ArrayList<String> add (String input, ArrayList<String> arrayList){
        String item = input.substring(input.indexOf(' '));
        arrayList.add(item.trim());
        return arrayList;
    }
    public static ArrayList<String> addPos(String input, ArrayList<String> arrayList){
        String noAdd = input.substring(input.indexOf(' '));
        String intPos = noAdd.substring(0, input.indexOf(' '));
        String item = noAdd.substring(input.indexOf(' '));
        int position = Integer.parseInt(intPos.trim());
        if(position <= arrayList.size())
            arrayList.add(position, item);
        else System.out.println("Нельзя поместить элемент на эту позицию");

        return arrayList;
    }
    public static void list(ArrayList<String> arrayList) {
        System.out.println("Список дела: ");
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(i + " - " + arrayList.get(i));
        }
    }

}
