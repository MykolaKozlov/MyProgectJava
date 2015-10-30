package FirstLesson.HomeworkFirstLesson.Library;
public class Demo {
	public static void main(String[] args) {
		Library library = new Library();
		library.addBookToLibrary("Erik Larson", "The Devil in the White City", Genre.History);
		library.printLibrary(library.authorLibrary);
		System.out.println("###################################################################");
		System.out.println("###################################################################");
		System.out.println("###################################################################");
		library.printLibrary(library.titleLibrary);
	}
}
