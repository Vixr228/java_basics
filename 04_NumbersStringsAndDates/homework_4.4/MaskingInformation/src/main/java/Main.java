public class Main {

    public static void main(String[] args) {
//        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008> 1234 <5678> 8912", "***");
//        System.out.println(safe);
        String str = "Номер кредитной карты <4008> 1234";
        String placeholder = "***";


    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        String textTemp = text;
        while (textTemp.indexOf('<') != -1 && textTemp.indexOf('>') != -1) {
            textTemp = textTemp.substring(0, textTemp.indexOf('<')) +
                    placeholder + textTemp.substring(textTemp.indexOf('>') + 1);
        }
        return textTemp;
    }

}