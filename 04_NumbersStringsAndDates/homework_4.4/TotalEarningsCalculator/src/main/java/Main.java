public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";


        int vasyaSalary = Integer.parseInt(text.substring(text.indexOf('5'), text.indexOf('5') + 4));
        int petyaSalary = Integer.parseInt(text.substring(text.indexOf('7'), text.indexOf('7') + 4));
        int mashaSalary = Integer.parseInt(text.substring(text.lastIndexOf('3'), text.lastIndexOf('3') + 5));
//        System.out.println("Зарплата Василия: " + vasyaSalary);
//        System.out.println("Зарплата Петра: " + petyaSalary);
//        System.out.println("Зарплата Марии: " + mashaSalary);
//        System.out.println("Сумма заработка: " + (vasyaSalary + mashaSalary + petyaSalary));
        System.out.println((vasyaSalary + mashaSalary + petyaSalary));
    }

}