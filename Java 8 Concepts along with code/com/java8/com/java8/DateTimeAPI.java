

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;

public class DateTimeAPI {
    public static void main(String[] args) {
        String dateStr = "31/02/2023";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate localDate = LocalDate.parse(dateStr,dateTimeFormatter);
            System.out.println("Valid date");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date");
        }


        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(dateStr, dateTimeFormatter2);
            System.out.println("Valid Date: " + date);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid Date");
        }


        //sceanrio number 2 --> find the number of days between 2 days

        String startDateStr = "2022-12-25";
        String endDateStr = "2023-01-01";

        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate startDate = LocalDate.parse(startDateStr,dateTimeFormatter3);
        LocalDate endDate = LocalDate.parse(endDateStr,dateTimeFormatter3);

        long daysBetween = ChronoUnit.DAYS.between(startDate,endDate);
        System.out.println(daysBetween);



        //scenario - 3  Adding days, month, years to a date

        String dateString = "2022-12-25";
        LocalDate date = LocalDate.parse(dateString, dateTimeFormatter3);

        LocalDate updatedDate = date.plusDays(daysBetween).plusMonths(2).plusYears(2);

        System.out.println(updatedDate);

        //scenario -4 Time difference minutes and hours
        String startTimeStr = "08:30:00";
        String endTimeStr = "14:15:00";
        
        LocalTime startTime = LocalTime.parse(startTimeStr);
        LocalTime endTime = LocalTime.parse(endTimeStr);

        Duration duration = Duration.between(startTime, endTime);
        long minutes = duration.toMinutes()%60;
        long hours = duration.toHours();

        System.err.println(hours + " " + minutes);



        //sceanrio - 5 compare 2 dates

        String dateStr1 = "2022-12-25";
        String dateStr2 = "2023-01-01";
        
        LocalDate date1 = LocalDate.parse(dateStr1);
        LocalDate date2 = LocalDate.parse(dateStr2);

        if(date1.isBefore(date2))
            System.out.println(date1 + " is before " + date2);
        else if(date1.isEqual(date2))
            System.out.println("Both dates are equal");
        else
            System.out.println(date2 + " is before " + date1);


     

    }

}
