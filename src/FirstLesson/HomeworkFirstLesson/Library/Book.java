package FirstLesson.HomeworkFirstLesson.Library;
public class Book {
	private String author;
	private String title;
	private Genre genre;

	Book (){
	}

	Book (String author, String title, Genre genre){
		this.author = author;
		this.title = title;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}
