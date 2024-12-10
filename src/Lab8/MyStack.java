package Lab8;

public class MyStack<T> {
    T[] mass;

    public MyStack(int size) {
        //Создаем массив и приводим его к обобщенному типу
        mass = (T[]) new Object[size];
    }

    public void push(T item) {
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] == null) {
                mass[i] = item;
                break;
            }
        }
    }

    public T pop() {
        for (int i = mass.length - 1; i >= 0; i--) {
            if (mass[i] != null) {
                T item = mass[i];
                mass[i] = null;
                return item;
            }
        }
        return null;
    }

    public void printStack() {
        for (int i = 0; i < mass.length; i++) {
            System.out.print("[" + mass[i] + "]");
            System.out.println();
        }
        System.out.println();
    }

    //получение текущего количества элементов в стеке
    public int size() {
        int count = 0;
        for (T item : mass) {
            if (item != null) {
                count++;
            }
        }
        return count;
    }

    //получение элемента по индексу
    public T get(int index) {
        if (index >= 0 && index < mass.length) {
            return mass[index];
        }
        throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона");
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}