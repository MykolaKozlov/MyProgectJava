package FirstLesson.Task25;

public class Task25 {
    private String name;
    private Task25 task;

    public Task25 (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Task25 getTask() {
        return task;
    }
    public void setTask(Task25 task) {
        this.task = task;
    }

    public void print(){
        System.out.println(name + " -> " + task.getName());
    }
}
