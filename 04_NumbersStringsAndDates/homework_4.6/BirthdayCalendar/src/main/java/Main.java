import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {

        int day = 18;
        int month = 11;
        int year = 2020;

        System.out.println(collectBirthdays(year, month, day));

    }


    public static String collectBirthdays(int year, int month, int day) {

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - EEE");

        GregorianCalendar calendarStart = new GregorianCalendar(year, month - 1, day);

        GregorianCalendar calendarCurr = new GregorianCalendar();

        StringBuilder result = new StringBuilder();

        int i = 0;
        while(calendarStart.before(calendarCurr)) {
            result.append(i + " - " + dateFormat.format(calendarStart.getTime()).toString() + "\n");
            calendarStart.add(Calendar.YEAR, 1);
            i++;
        }


        return result.toString();
    }
}
