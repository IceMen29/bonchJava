package Lab4Exceptions;
public class Main {
    public static void main(String[] args) {
        Exceptions.task1();

        try {
            Exceptions.enterArray();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        Exceptions.task3();


    }

}
