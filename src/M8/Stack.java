package src.M8;

public interface Stack<E> {
    void push(E e);
    E peek();
    E pop();
    int size();
    boolean isEmpty();
}
