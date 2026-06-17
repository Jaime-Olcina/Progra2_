package estructuras;

public class ListaEnlazada implements IListaEnlazada {
    class Elemento {
        public int dato;
        public Elemento siguiente;

        public Elemento(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
        public Elemento(int dato, Elemento siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }

        public Elemento siguiente() {
            return siguiente;
        }
    } 


    Elemento primero;

    public ListaEnlazada() {
        primero = null;
    }

    @Override
    public int acceder(int indice){
        if(primero == null) {
            return Integer.MIN_VALUE;
        }

        Elemento elem_indice_busq = primero;
        for (int indice_busq = 0; indice_busq < indice; indice_busq++) {
            elem_indice_busq = elem_indice_busq.siguiente();
            
            if(elem_indice_busq == null) {
                return Integer.MIN_VALUE;
            }
        }

        return elem_indice_busq.dato;
    }
    
    @Override
    public boolean borrar(int indice){
        return false;
    }

    @Override
    public boolean anyadir(int elemento) {
        if(primero == null) {
            primero = new Elemento(elemento);
            return true;
        }

        Elemento elem_ultimo = primero;
        while (elem_ultimo.siguiente != null) {
            elem_ultimo = elem_ultimo.siguiente();
        }

        elem_ultimo.siguiente = new Elemento(elemento);
        return true;
    }
    public boolean anyadir(int elemento, int lugar) {
        return false;
    }

    @Override
    public int buscar(int elemento) {
        return -1;
    }

    @Override
    public int tamanyo() {
        return 0;
    }

}
