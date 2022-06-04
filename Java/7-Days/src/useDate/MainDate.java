package useDate;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class MainDate {
    public static void main(String[] args) {

        Date date = new Date();
        LocalDateTime now = LocalDateTime.now();
        System.out.println( date );

        // date
        int year = now.getYear();
        int mounth = now.getMonthValue();
        int day = now.getDayOfMonth();
        String stMounth = mounth < 10 ? "0"+mounth : ""+mounth;
        String stDay = day < 10 ? "0"+day : ""+day;

        // time
        int hour = now.getHour();
        int min = now.getMinute();
        int sec = now.getSecond();
        String stHour = hour < 10 ? "0"+hour : ""+hour;
        String stMin = min < 10 ? "0"+min : ""+min;
        String stSec = sec < 10 ? "0"+sec : ""+sec;

        System.out.println( stDay + "-" + stMounth + "-" + year );
        System.out.println(stHour + ":" + stMin + ":" + stSec);

        // Simple date formatter
        String pattern = "dd-MM-yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String newFormat = simpleDateFormat.format(date);
        System.out.println( newFormat );

    }
}
