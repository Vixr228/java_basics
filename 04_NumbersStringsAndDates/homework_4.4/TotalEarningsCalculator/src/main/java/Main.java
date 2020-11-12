public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";



        String vasyaSalSubstr=text.substring(0,text.indexOf(" руб"));
        String vasyaSalStr=vasyaSalSubstr.substring(vasyaSalSubstr.lastIndexOf(' ')).trim();
        int vasyaSalary=Integer.parseInt(vasyaSalStr);

        String mashaSalSubst = text.substring(0, text.lastIndexOf(" руб"));
        String mashaSalStr = mashaSalSubst.substring(mashaSalSubst.lastIndexOf(' ')).trim();
        int mashaSalary = Integer.parseInt(mashaSalStr);

        String petyaSalSubstr = text.substring(text.indexOf("руб"), text.lastIndexOf("руб"));
        petyaSalSubstr = petyaSalSubstr.substring(0,petyaSalSubstr.lastIndexOf(" руб"));
        String petyaSalStr = petyaSalSubstr.substring(petyaSalSubstr.lastIndexOf(' ')).trim();
        int petyaSalary = Integer.parseInt(petyaSalStr);
//
//        System.out.println("Зарплата Василия: " + vasyaSalary);
//        System.out.println("Зарплата Петра: " + petyaSalary);
//        System.out.println("Зарплата Марии: " + mashaSalary);
        System.out.println((vasyaSalary + mashaSalary + petyaSalary));
    }

}