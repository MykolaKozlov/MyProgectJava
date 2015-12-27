package FourthLesson.HomeWork.Stack;

public class DemoStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");

        System.out.println("print stack");
        stack.printList();
        System.out.println("run pop");
        System.out.println(stack.pop());
        System.out.println("run peek");
        System.out.println(stack.peek());

    }
}
