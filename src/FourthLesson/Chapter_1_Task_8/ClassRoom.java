package FourthLesson.Chapter_1_Task_8;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {

    public List<Student> students = new ArrayList<>();

    public void enterClass(Student student) {
        students.add(student);
    }

    public void leaveClass(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.contains(student)) {
                students.remove(student);
            }
        }
    }

    public void getStudentCount() {
        System.out.println("Now in class " + students.size() + " students!");
    }

    public boolean isPresenr(String name, String secondName) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name) && students.get(i).getSecondName().equals(secondName)) {
                System.out.println(students.get(i).getName() + " " + students.get(i).getSecondName() + " is present!");
                return true;
            }
        }
        System.out.println(name + " " + secondName + " is absent");
        return false;
    }

    public void printStudentsInfo(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + 1 + ". " + students.get(i).getName() + " " + students.get(i).getSecondName());
        }
    }

    public List<Student> getStudents(){
        return new ArrayList<>(students);
    }

    public boolean isPresenr2(Student student) {
       if(students.contains(student)){
           System.out.println(student.getName() + " " + student.getSecondName());
           return true;
       }
        System.out.println("false");
        return false;
    }
}
