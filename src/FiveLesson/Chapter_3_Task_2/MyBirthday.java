package FiveLesson.Chapter_3_Task_2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyBirthday {

    public static void main(String[] args) {
        Date date = new Date();
        date.setDate(17);
        date.setMonth(03);
        date.setYear(90);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        System.out.println(dateFormat.format(date));
    }
}
