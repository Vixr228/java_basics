import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        int day = 18;
        int month = 11;
        int year = 2020;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - EEE");
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.set(year, month - 1, day);
        Calendar calendarCurr = Calendar.getInstance();
        String result = "";
        int i = 0;
       while(calendarStart.getTimeInMillis() <= calendarCurr.getTimeInMillis()) {
            result += i + " - " + dateFormat.format(calendarStart.getTime()).toString() + "\n";
            calendarStart.add(Calendar.YEAR, 1);
            i++;
        }


        return result;
    }
}
