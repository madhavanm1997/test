package java8;

import java.util.Calendar;

public class CalenderTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar.getTime(): " + calendar.getTime());
        System.out.println("calendar.getCalendarType(): " + calendar.getCalendarType());
        System.out.println("calendar.getTimeZone(): " + calendar.getTimeZone());
        System.out.println("calendar.get(Calendar.MINUTE): " + calendar.get(Calendar.MINUTE));
        System.out.println("calendar.get(Calendar.SECOND): " + calendar.get(Calendar.SECOND));

        //set a date
       // calendar.set(2019, 07, 27);
        System.out.println("calender: " + calendar.get(Calendar.YEAR));
        System.out.println("calender; "+ calendar.getMaximum(Calendar.DAY_OF_WEEK));

        //add a time
        calendar.add(Calendar.DATE,10);
        System.out.println("calendar.getTime(): "+calendar.getTime());
    }
}
