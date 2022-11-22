import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
   �������� ���������, ������� ������� ��������� ��� ������ �������� �� ���� ��� �� �������� �������
   � �������: �������, ���� � ���� ������.

   ���� �������� ��������� ��������� ��� ����������:
     int day = 31;
     int month = 12;
     int year = 1990;

    ������ ���������� ������:
      0 - 31.12.1990 - Mon
      1 - 31.12.1991 - Tue
      �
*/
        Scanner loScanner = new Scanner(System.in);
        System.out.println("Enter you birthday in format: dd.mm.yyyy");

        String loScannerVal = loScanner.nextLine();

        //������������� ������
        SimpleDateFormat loSimpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat loSimpleDateFormatOut = new SimpleDateFormat("dd.MM.yyyy EEE", Locale.ENGLISH);

        try {
            //Conv String -> Date
            Date loBirthdayDate = loSimpleDateFormat.parse(loScannerVal);

            //���� ��� ��������
            Calendar loCalendarBirthday = Calendar.getInstance();
            loCalendarBirthday.setTime(loBirthdayDate);
            System.out.println("Your Birthday: " + loCalendarBirthday.getTime());

            //������� ���� ����� Calendar
            Calendar loCalendarCurr = Calendar.getInstance();
            Date loCurrDate = loCalendarCurr.getTime();
            System.out.println("Current date: " + loCalendarCurr.getTime());

            //������� ����� ������
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