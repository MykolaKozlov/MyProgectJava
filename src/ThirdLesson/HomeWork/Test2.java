package ThirdLesson.HomeWork;

public class Test2 {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
            throw new IllegalStateException();
        } finally {
            System.out.println("I want to be printed");
        }
    }
}
//на сколько я понял тут выполнятся все блоки, первый блок создает ошибку, во втором мы ее ловим и создаем новую ошибку, а
//finally выполняется всегда!