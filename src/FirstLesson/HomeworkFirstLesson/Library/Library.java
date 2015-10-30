package FirstLesson.HomeworkFirstLesson.Library;

public class Library {
	private int alphabetSize = 25;
	private int numberOfBooks = 10;
	private String alphabet = "abcdefghijklmnopqrstuvwxyz";

	public Book[][] authorLibrary = new Book[alphabetSize][numberOfBooks];
	public Book[][] titleLibrary = new Book[alphabetSize][numberOfBooks];
	public Book[][] genreLibrary = new Book[Genre.values().length][numberOfBooks];


	public void addBookToLibrary(String author, String title, Genre genre) {
		Book book = new Book();
		book.setAuthor(author);
		book.setTitle(title);
		book.setGenre(genre);
		sortBookByAuthor(book);
		sortBookByTitle(book);


	}

	private int returnsPositionAuthorAndTitle(String text) {
		int position = 0;
		for (int i = 0; i < alphabet.length(); i++) {
			if (text.toLowerCase().trim().charAt(0) == alphabet.charAt(i)) {
				position = i;
			}
		}
		return position;
	}

	private int returnsPositionGenre(Genre genre) {
		int position = 0;
		for (int i = 0; i < Genre.values().length; i++) {
			if (Genre.values()[i] == genre) {
				position = i;
			}
		}
		return position;
	}

	private void sortBookByAuthor(Book book) {
		for (int i = 0; i < authorLibrary[returnsPositionAuthorAndTitle(book.getAuthor())].length; i++) {
			if (authorLibrary[returnsPositionAuthorAndTitle(book.getAuthor())][i] == null) {
				authorLibrary[returnsPositionAuthorAndTitle(book.getAuthor())][i] = book;
				return;
			}
			if (i == authorLibrary[returnsPositionAuthorAndTitle(book.getAuthor())].length - 1) {
				System.out.println("You need increase size \"authorLibrary\"");
			}
		}
	}

	private void sortBookByTitle(Book book) {
		for (int i = 0; i < titleLibrary[returnsPositionAuthorAndTitle(book.getTitle())].length; i++) {
			if (titleLibrary[returnsPositionAuthorAndTitle(book.getTitle())][i] == null) {
				titleLibrary[returnsPositionAuthorAndTitle(book.getTitle())][i] = book;
				return;
			}
			if (i == titleLibrary[returnsPositionAuthorAndTitle(book.getTitle())].length - 1) {
				System.out.println("You need increase size \"titleLibrary\"");
			}
		}
	}

	private void sortBookByGenre(Book book) {
		for (int i = 0; i < genreLibrary; i++) {
			if (genreLibrary[returnsPositionAuthorAndTitleAuthorAndTitle(book.getTitle())][i] == null) {
				genreLibrary[returnsPositionAuthorAndTitleAuthorAndTitle(book.getTitle())][i] = book;
				return;
			}
			if (i == genreLibrary[returnsPositionAuthorAndTitleAuthorAndTitle(book.getTitle())].length - 1) {
				System.out.println("You need increase size \"titleLibrary\"");
			}
		}
	}

	public void printLibrary(Book[][] library) {
		for (int i = 0; i < library.length; i++) {
			for (int j = 0; j < library[i].length; j++) {
				if (library[i][j] == null) {
					System.out.print("null   ");
				} else {
					System.out.print("Book author - " + library[i][j].getAuthor() + "; " + "Book title - " + library[i][j].getTitle() + "; " + "Book genre - " + library[i][j].getGenre() + "   ");
				}
			}
			System.out.println();
		}
	}
}
