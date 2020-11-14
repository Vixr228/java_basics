public class Main {

    public static void main(String[] args) {
        String text = "the level of lifespan-is-kek higher than it was 40 years ago.";
        System.out.println(splitTextInToWords(text));
    }

    public static String splitTextInToWords(String text) {
        String res = text.replaceAll("[0-9\\,\\.\\?\\!\\:\\;]", "");
        res = res.replaceAll("\\s\\s", " ");
        res = res.replaceAll("[\\s\\-]", "\n");
        return res;

    }

}