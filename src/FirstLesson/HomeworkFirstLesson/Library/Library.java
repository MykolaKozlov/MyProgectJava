package FirstLesson.HomeworkFirstLesson.Library;

public class Library {
	private int alphabetSize = 26;
	private int numberOfBooks = 100;
	private String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private int returnPosition = 0;

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
		sortBookByGenre(book);
	}

	private int returnsPositionAuthorAndTitle(String text) {
		int position = 0;
		for (int i = 0; i < alphabet.length(); i++) {
			if (text.toLowerCase().trim().charAt(0) == alphabet.charAt(i)) {
				position = i;
				break;
			}
		}
		return position;
	}

	private int returnsPositionGenre(Genre genre) {
		int position = 0;
		for (int i = 0; i < Genre.values().length; i++) {
			if (Genre.values()[i] == genre) {
				position = i;
				break;
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
				break;
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
				break;
			}
		}
	}

	private void sortBookByGenre(Book book) {
		for (int i = 0; i < genreLibrary[returnsPositionGenre(book.getGenre())].length; i++) {
			if (genreLibrary[returnsPositionGenre(book.getGenre())][i] == null) {
				genreLibrary[returnsPositionGenre(book.getGenre())][i] = book;
				return;
			}
			if (i == genreLibrary[returnsPositionGenre(book.getGenre())].length - 1) {
				System.out.println("You need increase size \"genreLibrary\"");
				break;
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

	public void findBookByAuthor(String author) {
		int position = 0;
		for (int i = 0; i < authorLibrary[returnsPositionAuthorAndTitle(author)].length; i++) {
			if (authorLibrary[returnsPositionAuthorAndTitle(author)][i] == null && position == 0) {
				System.out.println("For a given request variants not found, please change the input parametrs!!!");
				break;
			} else if (authorLibrary[returnsPositionAuthorAndTitle(author)][i] == null) {
				break;
			} else if (authorLibrary[returnsPositionAuthorAndTitle(author)][i].getAuthor() == author) {
				System.out.println("Book author - " + authorLibrary[returnsPositionAuthorAndTitle(author)][i].getAuthor() + "; " + "Book title - " + authorLibrary[returnsPositionAuthorAndTitle(author)][i].getTitle() + "; " + "Book genre - " + authorLibrary[returnsPositionAuthorAndTitle(author)][i].getGenre());
				position = authorLibrary[returnsPositionAuthorAndTitle(author)].length + 1;
			}
		}
	}

	public void findBookByTitle(String title) {
		int position = 0;
		for (int i = 0; i < titleLibrary[returnsPositionAuthorAndTitle(title)].length; i++) {
			if (titleLibrary[returnsPositionAuthorAndTitle(title)][i] == null && position == 0) {
				System.out.println("For a given request variants not found, please change the input parametrs!!!");
				break;
			} else if (titleLibrary[returnsPositionAuthorAndTitle(title)][i] == null) {
				break;
			} else if (titleLibrary[returnsPositionAuthorAndTitle(title)][i].getTitle() == title) {
				System.out.println("Book author - " + titleLibrary[returnsPositionAuthorAndTitle(title)][i].getAuthor() + "; " + "Book title - " + titleLibrary[returnsPositionAuthorAndTitle(title)][i].getTitle() + "; " + "Book genre - " + titleLibrary[returnsPositionAuthorAndTitle(title)][i].getGenre());
				position = titleLibrary[returnsPositionAuthorAndTitle(title)].length + 1;
			}
		}
	}

	public void findBookByGenre(Genre genre) {
		int position = 0;
		for (int i = returnPosition; i < genreLibrary[returnsPositionGenre(genre)].length; i++) {
			if (genreLibrary[returnsPositionGenre(genre)][i] == null && position == 0) {
				System.out.println("For a given request variants not found, please change the input parametrs!!!");
				break;
			} else if (genreLibrary[returnsPositionGenre(genre)][i] == null) {
				break;
			} else if (genreLibrary[returnsPositionGenre(genre)][i].getGenre() == genre) {
				System.out.println("Book author - " + genreLibrary[returnsPositionGenre(genre)][i].getAuthor() + "; " + "Book title - " + genreLibrary[returnsPositionGenre(genre)][i].getTitle() + "; " + "Book genre - " + genreLibrary[returnsPositionGenre(genre)][i].getGenre());
				position = genreLibrary[returnsPositionGenre(genre)].length + 1;
				returnPosition++;
				if (returnPosition % 5 == 0) {
					break;
				}
			}
		}
	}
}
