package estructuras;

public class Pila<T> implements IPila<T> {
    class Elemento {
        T dato;
        Elemento siguiente;

        public Elemento(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }

        public Elemento(T dato, Elemento siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }   

    Elemento primero;
    public Pila() {
        this.primero = null;
    }

    @Override
    public boolean empty() {
        return this.primero == null;
    }

    @Override
    public T pop() { // Devolver el elemento del principio y borrarlo
        //return primero.dato; // faltaria borrarlo

        if (primero != null) {
            Elemento nuevo_primero = primero.siguiente;
            T dato = primero.dato; // para no perderlo al cambiar de primero
            primero = nuevo_primero;

            return dato;
        }
        return null;
    }

    @Override
    public void push(T t) { // Anyadir un elemento al principio
        if (primero == null) {
            primero = new Elemento(t);
        }
        else {
            Elemento nuevo_segundo = primero;
            primero = new Elemento(t, nuevo_segundo);
        }
    }

    @Override
    public T peek() { // mira cual es el primero, pero no lo borra
        if (primero != null) {
            return primero.dato;
        }
        else return null;
    }


    @Override
    public String toString() {
        String elementos = "";
        Elemento siguiente = primero;
        while (siguiente != null) {
            elementos += siguiente.dato + ", ";
            siguiente = siguiente.siguiente;
        }

        return elementos;
    }
}
