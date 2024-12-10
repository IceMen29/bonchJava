package Lab8;

public class ProgramA {
    public static void main(String[] args) {
        MyStack<Integer> myStackInt = new MyStack<>(16);
        myStackInt.push(10);
        myStackInt.printStack();
        myStackInt.push(1455);
        myStackInt.push(106);
        myStackInt.printStack();
        myStackInt.pop();
        myStackInt.printStack();

        MyStack<String> myStackString = new MyStack<>(10);
        myStackString.push("34frfrfr");
        myStackString.push("12frfedrfr");
        myStackString.push("65frfrfr");
        myStackString.printStack();
        myStackString.pop();
        myStackString.pop();
        myStackString.printStack();
    }
}
