import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
   Напишите программу, которая покажет прошедшие дни вашего рождения от нуля лет до текущего времени
   в формате: возраст, дата и день недели.

   Дату рождения задавайте используя три переменные:
     int day = 31;
     int month = 12;
     int year = 1990;

    Формат требуемого вывода:
      0 - 31.12.1990 - Mon
      1 - 31.12.1991 - Tue
      …
*/
        Scanner loScanner = new Scanner(System.in);
        System.out.println("Enter you birthday in format: dd.mm.yyyy");

        String loScannerVal = loScanner.nextLine();

        //Представление данных
        SimpleDateFormat loSimpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat loSimpleDateFormatOut = new SimpleDateFormat("dd.MM.yyyy EEE", Locale.ENGLISH);

        try {
            //Conv String -> Date
            Date loBirthdayDate = loSimpleDateFormat.parse(loScannerVal);

            //Дата дня рождения
            Calendar loCalendarBirthday = Calendar.getInstance();
            loCalendarBirthday.setTime(loBirthdayDate);
            System.out.println("Your Birthday: " + loCalendarBirthday.getTime());

            //Текущая дата через Calendar
            Calendar loCalendarCurr = Calendar.getInstance();
            Date loCurrDate = loCalendarCurr.getTime();
            System.out.println("Current date: " + loCalendarCurr.getTime());

            //Разница между датами
            int lvPorNumb = 0;
            if (loCalendarBirthday.after(loCalendarCurr)) {
                System.out.println("Impossible");
            } else {
                while (loCalendarBirthday.before(loCalendarCurr)) {
                    System.out.println(lvPorNumb + " - " + loSimpleDateFormatOut.format(loCalendarBirthday.getTime()));
                    loCalendarBirthday.add(Calendar.YEAR, 1);
                    lvPorNumb += 1;
                }
            }
        } catch (ParseException lxE) {
            lxE.printStackTrace();
        }
    }
}