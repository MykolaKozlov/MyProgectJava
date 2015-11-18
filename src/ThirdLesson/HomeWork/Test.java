package ThirdLesson.HomeWork;

public class Test {
    public static void main(String[] args) {
        try {
            return;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("I want to be executed!");
        }
    }
}
//тут выполнится только блок finally, так как спервого блока мы выходим через оператор return, второй блок мы пропускаем
//так как не ловим никакую ошибку, а finally выполняется всегда!!!
