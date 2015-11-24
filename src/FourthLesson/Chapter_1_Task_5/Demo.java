package FourthLesson.Chapter_1_Task_5;

public class Demo {
    public static void main(String[] args) {
        ClassRoom classRoom = new ClassRoom();

        Student student1 = new Student();
        student1.setName("Mykola");
        student1.setSecondName("Kozlov");

        Student student2 = new Student();
        student2.setName("Igor");
        student2.setSecondName("Burda");

        Student student3 = new Student();
        student3.setName("Vasiliy");
        student3.setSecondName("Grach");

        Student student4 = new Student();
        student4.setName("Marina");
        student4.setSecondName("Komleva");

        Student student5 = new Student();
        student5.setName("Inna");
        student5.setSecondName("Zhukova");

        Student student6 = new Student();
        student6.setName("Ylia");
        student6.setSecondName("Kozlova");

        Student student7 = new Student();
        student7.setName("Masha");
        student7.setSecondName("Kotova");

        classRoom.enterClass(student1);
        classRoom.enterClass(student2);
        classRoom.enterClass(student3);
        classRoom.enterClass(student4);
        classRoom.enterClass(student5);
        classRoom.enterClass(student6);
        classRoom.enterClass(student7);

        classRoom.leaveClass(student3);

        classRoom.getStudentCount();

        classRoom.isPresenr("Mykola", "Kozlov");

        classRoom.isPresenr("Vasiliy", "Boyko");

        classRoom.printStudentsInfo(classRoom.students);

        classRoom.printStudentsInfo(classRoom.getStudents());
    }
}
