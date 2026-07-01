

public class Nodo<T> implements Comparable<Nodo<T>> {

    T prod;
    Nodo<T> izq, dcha;

    public Nodo(T prod) {
        this.prod = prod;
        this.izq = this.dcha = null; 
    }

    @Override
    public String toString() {
        return prod.toString();
    }

    @Override
    public int compareTo(Nodo<T> obj) {
        Nodo<T> otro = (Nodo<T>) obj;
        return otro.compareTo(obj);
    }
}
