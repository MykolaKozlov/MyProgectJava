package SixLesson.Chapter_2_Task_6;

public interface Observable {

    public void addObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}
