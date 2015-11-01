package FirstLesson.HomeworkFirstLesson.Library;
public class Demo {
	public static void main(String[] args) {
		Library library = new Library();

//		test add book to library
		library.addBookToLibrary("Erik Larson", "The Devil in the White City", Genre.History);
		library.addBookToLibrary("Daniel James Brown", "The Boys in the Boat", Genre.History);
		library.addBookToLibrary("Clinton Emerson", "Deadly Skills", Genre.History);
		library.addBookToLibrary("Nora Roberts", "Stars of Fortune", Genre.Romance);
		library.addBookToLibrary("Tara Brown", "Born", Genre.Teens);
		library.addBookToLibrary("Erin Leigh", "Roommates", Genre.Teens);
//		test find book by Author
		library.findBookByAuthor("Erik Larson");
//		test find book by Title
		library.findBookByTitle("Born");
//		test add book to library for find book by Genre
		library.addBookToLibrary("1", "1", Genre.History);
		library.addBookToLibrary("2", "1", Genre.History);
		library.addBookToLibrary("3", "1", Genre.History);
		library.addBookToLibrary("4", "1", Genre.History);
		library.addBookToLibrary("5", "1", Genre.History);
		library.addBookToLibrary("6", "1", Genre.History);
		library.addBookToLibrary("7", "1", Genre.History);
		library.addBookToLibrary("8", "1", Genre.History);
		library.addBookToLibrary("9", "1", Genre.History);
		library.addBookToLibrary("10", "1", Genre.History);
		library.addBookToLibrary("11", "1", Genre.History);
		library.addBookToLibrary("12", "1", Genre.History);
		library.addBookToLibrary("13", "1", Genre.History);
		library.addBookToLibrary("14", "1", Genre.History);
		library.addBookToLibrary("15", "1", Genre.History);
		library.addBookToLibrary("16", "1", Genre.History);
		library.addBookToLibrary("17", "1", Genre.History);
		library.addBookToLibrary("18", "1", Genre.History);
		library.addBookToLibrary("19", "1", Genre.History);
		library.addBookToLibrary("20", "1", Genre.History);
//		test find book by Genre
		library.findBookByGenre(Genre.History);
		library.findBookByGenre(Genre.History);
		library.findBookByGenre(Genre.History);
		library.findBookByGenre(Genre.History);
		library.findBookByGenre(Genre.History);

//		test print library

//		library.printLibrary(library.authorLibrary);
//		System.out.println("###################################################################");
//		System.out.println("###################################################################");
//		System.out.println("###################################################################");
//		library.printLibrary(library.titleLibrary);
//		System.out.println("###################################################################");
//		System.out.println("###################################################################");
//		System.out.println("###################################################################");
//		library.printLibrary(library.genreLibrary);
	}
}
