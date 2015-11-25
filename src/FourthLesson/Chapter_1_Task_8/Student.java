package FourthLesson.Chapter_1_Task_8;

public class Student {

    private String name;
    private String secondName;

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!name.equals(student.name)) return false;
        return secondName.equals(student.secondName);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + secondName.hashCode();
        return result;
    }
}
