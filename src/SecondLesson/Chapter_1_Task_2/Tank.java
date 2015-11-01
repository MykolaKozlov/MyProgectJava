package SecondLesson.Chapter_1_Task_2;

public class Tank {
	Colour colour;
	int crew;
	int speed;

	public Tank() {
	}

	public Tank(Colour colour) {
		this.colour = colour;
	}

	public Tank(Colour colour, int crew, int speed) {
		this.colour = colour;
		this.crew = crew;
		this.speed = speed;
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
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
