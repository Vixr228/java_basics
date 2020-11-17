public class Main {

    public static void main(String[] args) {
        String text = "the level of lifespan-is-kek higher. than? it! was 40 years ago.";
        System.out.println(splitTextInToWords(text));
    }

    public static String splitTextInToWords(String text) {
        if(text.equals("")) return "";
        text = text.replaceAll("\\d", "");
        String mas[] = text.split("(\\s\\s|\\s|\\.\\s|\\?\\s|\\!\\s|\\;\\s|\\:\\s|\\,\\s|\\.|\\-)");
        String res = mas[0];
        for (int i = 1; i < mas.length; i++) {
            res += System.lineSeparator() + mas[i];
        }
        return res;

    }

}