package FourthLesson.Chapter_2_Task_16;

public class Comparator implements java.util.Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int value = o1.compareToIgnoreCase(o2);
        if (value > 0) {
            return -1;
        } else if (value < 0) {
            return 1;
        } else {
            return 0;
        }
    }
}


