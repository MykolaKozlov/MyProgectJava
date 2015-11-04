package SecondLesson.Chapter_4_Task_5;

public class DarkZone {

    private double procentFromSumm(double summ, double prosent) {
        double result = summ + (prosent / 100) * summ / 12;
        return result;
    }

    public void darkZone(double monthlyPayment, double interest, double dreamSum) {
        double summ = monthlyPayment;
        for (int i = 1; i < dreamSum; i++) {
            if (summ >= dreamSum){
                System.out.println("Year " + i/12 + ": " + "Month " + i%12);
                break;
            }
            double result = procentFromSumm(summ, interest);
            summ = monthlyPayment + result;
        }
    }
}
