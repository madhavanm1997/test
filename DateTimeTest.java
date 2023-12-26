package java8;

/*import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;*/

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeTest {
    public static void main(String[] args) {

        //formatter
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd:MM:yyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");

        //zoneDateTime
        ZonedDateTime currentZone = ZonedDateTime.now();
        System.out.println("currentZone: " + currentZone);
        ZoneId zoneId = ZoneId.of("Asia/Tokyo");
        ZonedDateTime zonedDateTime = currentZone.withZoneSameInstant(zoneId);
        System.out.println("zonedDateTime: " + zonedDateTime);

        //current dates
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate: " + localDate);
        System.out.println("formatter: " + localDate.format(dateFormatter));
        System.out.println("localDate.getDayOfMonth(): " + localDate.getDayOfMonth());

        //current times
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime: " + localTime);
        System.out.println("formatter: " + localTime.format(timeFormatter));
        System.out.println("localTime.getHour(): " + localTime.getHour());

        //current date&time
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime: " + localDateTime);
        System.out.println("formatter: " + localDateTime.format(dateTimeFormatter));

    }
}
