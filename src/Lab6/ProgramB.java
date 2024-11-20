package Lab6;

public class ProgramB {
    public static void main(String[] args) {
        Book book1 = new Book("book1", "Электронная");
        Book book2 = new Book("book2", "На бумаге");
        MyStack<Book> myStackBooks = new MyStack<>(16);
        myStackBooks.push(book1);
        myStackBooks.push(book2);
        myStackBooks.pop();
        myStackBooks.push(new Book("book3", "На бумаге"));
        myStackBooks.printStack();
    }
}


class Book {

    String name;
    String type;


    Book(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name + "{type='" + type + "'}";
    }
}