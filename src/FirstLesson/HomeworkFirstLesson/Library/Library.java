package FirstLesson.HomeworkFirstLesson.Library;
public class Library {
	private int alphabetSize = 25;
	private int minimumNumberOfBooks = 10;
	private String alphabet = "abcdefghijklmnopqrstuvwxyz";

	Book [][] authorLibrary = new Book[alphabetSize][minimumNumberOfBooks];
	Book [][] titleLibrary = new Book[alphabetSize][minimumNumberOfBooks];
	Book [][] genreLibrary = new Book[alphabetSize][minimumNumberOfBooks];


	public void addBookToLibrary (String author, String title, Genre genre){
		Book book = new Book();
		book.setAuthor(author);
		book.setTitle(title);
		book.setGenre(genre);
		sortBookByAuthor(book);


	}

	private int returnsPosition (String text){
		int position = 0;
		for (int i = 0; i < alphabet.length(); i++){
			if (text.toLowerCase().trim().charAt(0) == alphabet.charAt(i)){
				position = i;
			}
		}
		return position;
	}

	private void sortBookByAuthor (Book book){
		for (int i = 0; i < authorLibrary[returnsPosition(book.getAuthor())].length; i++){
			if (authorLibrary [returnsPosition(book.getAuthor())] [i] == null){
				authorLibrary [returnsPosition(book.getAuthor())][i] = book;
				return;
			} if (i == authorLibrary [returnsPosition(book.getAuthor())].length - 1){
				System.out.println("You need increase size \"authorLibrary\"");
			}
		}
	}

	public void printAuthorLibrary (Book [][] authorLibrary){
		for (int i = 0; i < authorLibrary.length; i++){
			for (int j = 0; j < authorLibrary [i].length; j++){
				if (authorLibrary[i][j] == null){
					System.out.print("null   ");
				} else {
					System.out.print("Book author - " + authorLibrary[i][j].getAuthor() + "; " + "Book title - " + authorLibrary[i][j].getTitle() + "; " + "Book genre - " + authorLibrary[i][j].getGenre() + "   ");
				}
			}
			System.out.println();

		}
	}


}
