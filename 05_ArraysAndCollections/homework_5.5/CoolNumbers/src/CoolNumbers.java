import java.util.*;

public class CoolNumbers {
    public static void main(String[] args) {
        ArrayList<String> numbersArrayList = new ArrayList<>();
        String findNum  = "Н777УУ199";

        long startTime = System.nanoTime();
        numbersArrayList = generateCoolNumbers();
        long finishTime = System.nanoTime();
        System.out.println("Время формирования массива: " + (finishTime - startTime));
        System.out.println("Количество элементов в массиве: " + numbersArrayList.size());
        //printArray(numbersArrayList);

        //Поиск перебором
        findInArrayList(numbersArrayList, findNum);
        //Бинарный поиск
        binarySearchInArray(numbersArrayList, findNum);
        //Поиск в хеш-сет
        HashSet<String> numbersHashSet = new HashSet<>(numbersArrayList);
        findInHashSet(numbersHashSet, findNum);
        //Поиск в три-сет
        TreeSet<String> numbersTreeSet = new TreeSet<>(numbersArrayList);
        findInTreeSet(numbersTreeSet, findNum);

    }

    private static void binarySearchInArray(ArrayList<String> numbersList, String findNumber){
        Collections.sort(numbersList);
        long startTime = System.nanoTime();
        int bin = Collections.binarySearch(numbersList, findNumber);
        long finishTime = System.nanoTime();
        if (bin >= 0) System.out.println("Бинарный поиск: номер найден, поиск занял " + (finishTime - startTime) + " нс");
        else System.out.println("Бинарный поиск: номер не найден, поиск занял " + (finishTime - startTime) + " нс");
    }

    private static void findInHashSet(HashSet<String> hashSet, String findNumber){
        long startTime = System.nanoTime();
        boolean isFind = hashSet.contains(findNumber);
        long finishTime = System.nanoTime();
        if (isFind) System.out.println("Поиск в HashSet: номер найден, поиск занял " + (finishTime - startTime) + " нс");
        else System.out.println("Поиск в HashSet: номер не найден, поиск занял " + (finishTime - startTime) + " нс");
    }

    private static void findInTreeSet(TreeSet<String> treeSet, String findNumber){
        long startTime = System.nanoTime();
        boolean isFind = treeSet.contains(findNumber);
        long finishTime = System.nanoTime();
        if (isFind) System.out.println("Поиск в TreeSet: номер найден, поиск занял " + (finishTime - startTime) + " нс");
        else System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + (finishTime - startTime) + " нс");
    }

    private static ArrayList<String> generateCoolNumbers() {
        /*
        XYZ — различные буквы, N — цифры, R — регион (от 01 до 199);
        XNNNYZR — пример: A111BC197, Y777HC66.
         */
        ArrayList<String> numbersList = new ArrayList<>();
        char[] alphabet = "АВЕКМНОРСТУХ".toCharArray();

        //region
        for (int region = 1; region < 200; region++) {
            //3 буква
            for (int z = 0; z < alphabet.length; z++) {
                //2 буква
                for (int y = 0; y < alphabet.length; y++) {
                    //цифры
                    for (int n = 0; n < 10; n++) {
                        //1 буква
                        for (int x = 0; x < alphabet.length; x++) {
//                            numbersList.add(new StringBuilder().append(Character.toString(alphabet[x]))
//                                    .append(Integer.toString(n))
//                                    .append(Integer.toString(n))
//                                    .append(Integer.toString(n))
//                                    .append(Character.toString(alphabet[y]))
//                                    .append(Character.toString(alphabet[z]))
//                                    .append(Integer.toString(region)));
                            numbersList.add(Character.toString(alphabet[x]) +
                                    Integer.toString(n) +
                                    Integer.toString(n) +
                                    Integer.toString(n) +
                                    Character.toString(alphabet[y]) +
                                    Character.toString(alphabet[z]) +
                                    Integer.toString(region));

                        }
                    }
                }
            }
        }

        return numbersList;
    }


    private static void printArray(ArrayList<String> arrayList) {
        for (String item : arrayList) {
            System.out.println(item);
        }
    }

    private static void printSet (Set<String> set){
        for(String item : set){
            System.out.println(item);
        }
    }

    private static void findInArrayList(ArrayList<String> numbersList, String findNumber) {
        boolean flag = false;
        long startTime = System.nanoTime();
        for (String item : numbersList) {
            if (item.equals(findNumber)) flag = true;
        }
        long finishTime = System.nanoTime();
        if (flag) System.out.println("Поиск перебором: номер найден, поиск занял " + (finishTime - startTime) + " нс");
        else System.out.println("Поиск перебором: номер не найден, поиск занял " + (finishTime - startTime) + " нс");
    }
}
