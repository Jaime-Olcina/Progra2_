package estructuras;

public interface IPila<T> {
    public boolean empty();

    public T pop();

    public void push(T t);

    public T peek();
}
