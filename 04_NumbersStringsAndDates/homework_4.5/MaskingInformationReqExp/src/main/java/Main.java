public class Main {

    public static void main(String[] args) {

        //done
        String text = "Номер <кредитной> карты <4008 1234 5678> 8912";
        String placeholder = "***";
        System.out.println(searchAndReplaceDiamonds(text, placeholder));
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        text = text.replaceAll("<[^<>]+>", placeholder);
        return text;
    }

}