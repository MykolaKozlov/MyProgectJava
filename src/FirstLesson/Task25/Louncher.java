package FirstLesson.Task25;
public class Louncher {
    public static void main(String[] args) {
        Task25 ref1 = new Task25("ref1");
        Task25 ref2 = new Task25("ref2");
        Task25 ref3 = new Task25("ref3");

        ref1.setTask(ref2);
        ref2.setTask(ref3);
        ref3.setTask(ref1);

        ref1.print();
        ref2.print();
        ref3.print();
    }
}
