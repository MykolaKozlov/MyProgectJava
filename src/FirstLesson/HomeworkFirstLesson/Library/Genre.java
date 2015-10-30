package FirstLesson.HomeworkFirstLesson.Library;

public enum Genre {
	Biographies(0), Business(1), History(2), Literature(3), Religion(4), Romance(5), Fantasy(6), Self_Help(7), Teens(8);

	private int id;

	private Genre(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
