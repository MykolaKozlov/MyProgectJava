package FirstLesson.HomeworkFirstLesson.Library;
public class Demo {
	public static void main(String[] args) {
		Library library = new Library();
		library.addBookToLibrary("Erik Larson", "The Devil in the White City", Genre.History);
		library.addBookToLibrary("Daniel James Brown", "The Boys in the Boat", Genre.History);
		library.addBookToLibrary("Clinton Emerson", "Deadly Skills", Genre.History);
		library.addBookToLibrary("Nora Roberts", "Stars of Fortune", Genre.Romance);
		library.addBookToLibrary("Tara Brown", "Born", Genre.Teens);
		library.addBookToLibrary("Erin Leigh", "Roommates", Genre.Teens);

		library.findBookByAuthor("Erik Larson");
		library.findBookByTitle("Born");

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
