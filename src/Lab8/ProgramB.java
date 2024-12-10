package Lab8;

public class ProgramB {
    public static void main(String[] args) {
        MyStack<Book> myStackBooks = new MyStack<>(26);

        myStackBooks.push(new Book("Евгений Онегин", "Электронная", "Пушкин", 100));
        myStackBooks.push(new Book("Война и мир", "Бумажная", "Толстой", 200));
        myStackBooks.push(new Book("Преступление и наказание", "Электронная", "Достоевский", 300));
        myStackBooks.push(new Book("Мёртвые души", "Бумажная", "Гоголь", 400));
        myStackBooks.push(new Book("Чайка", "Электронная", "Чехов", 150));
        myStackBooks.push(new Book("Мастер и Маргарита", "Бумажная", "Булгаков", 350));
        myStackBooks.push(new Book("Отцы и дети", "Электронная", "Тургенев", 250));
        myStackBooks.push(new Book("Стихи", "Бумажная", "Есенин", 180));
        myStackBooks.push(new Book("Облако в штанах", "Электронная", "Маяковский", 190));
        myStackBooks.push(new Book("Реквием", "Бумажная", "Ахматова", 210));
        myStackBooks.push(new Book("Стихи о Москве", "Электронная", "Цветаева", 220));
        myStackBooks.push(new Book("Архипелаг ГУЛАГ", "Бумажная", "Солженицын", 310));
        myStackBooks.push(new Book("Тихий Дон", "Электронная", "Шолохов", 320));
        myStackBooks.push(new Book("Мать", "Бумажная", "Горький", 400));
        myStackBooks.push(new Book("Двенадцать", "Электронная", "Блок", 170));
        myStackBooks.push(new Book("Доктор Живаго", "Бумажная", "Пастернак", 360));
        myStackBooks.push(new Book("Повести Белкина", "Электронная", "Пушкин", 120));
        myStackBooks.push(new Book("Анна Каренина", "Бумажная", "Толстой", 230));
        myStackBooks.push(new Book("Братья Карамазовы", "Электронная", "Достоевский", 450));
        myStackBooks.push(new Book("Ревизор", "Бумажная", "Гоголь", 170));
        myStackBooks.push(new Book("Палата №6", "Электронная", "Чехов", 140));
        myStackBooks.push(new Book("Белая гвардия", "Бумажная", "Булгаков", 280));
        myStackBooks.push(new Book("Записки охотника", "Электронная", "Тургенев", 220));
        myStackBooks.push(new Book("Лирика", "Бумажная", "Есенин", 190));
        myStackBooks.push(new Book("Любовь и нежность", "Электронная", "Ахматова", 200));
        myStackBooks.push(new Book("Детство", "Бумажная", "Толстой", 150));

        // Выводим стек
        myStackBooks.printStack();

        Thread countAuthorBooksThread = new Thread(new Runnable() {
            public void run() {
                String author = "Толстой";
                int count = 0;
                for (int i = 0; i < myStackBooks.size(); i++) {
                    Book book = myStackBooks.get(i);
                    if (book != null && book.author.equals(author)) {
                        count++;
                    }
                }
                System.out.println("Количество книг автора " + author + ": " + count);
            }
        });

        // Поток для поиска книги с наибольшим количеством страниц
        Thread maxPagesBookThread = new Thread(new Runnable() {
            public void run() {
                Book maxPagesBook = null;
                for (int i = 0; i < myStackBooks.size(); i++) {
                    Book book = myStackBooks.get(i);
                    if (book != null && (maxPagesBook == null || book.pages > maxPagesBook.pages)) {
                        maxPagesBook = book;
                    }
                }
                if (maxPagesBook != null) {
                    System.out.println("Книга с наибольшим числом страниц: " + maxPagesBook.name);
                }
            }
        });

        // Запуск потоков
        countAuthorBooksThread.start();
        maxPagesBookThread.start();
    }

}



class Book {

    String name;
    String type;
    String author;
    int pages;

    Book(String name, String type, String author, int pages) {
        this.name = name;
        this.type = type;
        this.author = author;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return name + "{type='" + type + "', pages='" + pages + "', author='" + author + "'}";
    }
}