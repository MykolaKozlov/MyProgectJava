package FirstLesson.Task23;
public class Tank {
    String colour;
    int crew;
    int speed;

    public Tank (String colour) {
        this.colour = colour;
    }

    public Tank(String colour, int crew, int speed) {
        this.colour = colour;
        this.crew = crew;
        this.speed = speed;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
