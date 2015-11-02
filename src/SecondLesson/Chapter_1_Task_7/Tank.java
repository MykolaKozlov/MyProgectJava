package SecondLesson.Chapter_1_Task_7;

public class Tank {
	private Colour colour;
	private int crew;
	private int speed;
	private String name;

	public Tank() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;

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

	public void move(){
		System.out.println(name + " is moving");
	}

	@Override
	public String toString() {
		return "Tank{" +
				"colour=" + colour +
				", crew=" + crew +
				", speed=" + speed +
				", name='" + name + '\'' +
				'}';
	}
}
