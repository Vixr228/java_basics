public class Main {
    public static void main(String[] args) {

        String phrase = "Каждый охотник желает знать, где сидит фазан";
        String[] phraseArr = phrase.split(",?\\s+");
        reversArray(phraseArr);
        printArray(phraseArr);

    }
    public static String[] reversArray(String[] array){
        int size = array.length;
        for (int i = 0; i < size / 2; i++) {
            String temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }
        return array;
    }
    public static void printArray(String[] array){
        for(String arrayElements : array)
            System.out.println(arrayElements);
    }
}
