package estructuras;

public class BST implements IBST {
    
    class Nodo {
        int valor; // Como voy a comparar, no puede estar vacio
        Nodo izq, dcho; // Pueden estar vacios

        public Nodo(int valor) {
            this.valor = valor;
            izq = null;
            dcho = null;
        }

        @Override
        public String toString() {
            String subarbol = String.valueOf(valor);
            if(izq != null) {
                subarbol += " " + izq.toString();
            }
            if(dcho != null) {
                subarbol += " " + dcho.toString();
            }

            return subarbol;
        }

        void add(int num) {
            if(num < valor) {
                if(izq == null) {
                    // CASO BASE - TERMINO
                    izq = new Nodo(num);
                    return;
                }

                izq.add(num);
            }
            else {
                if(dcho == null) {
                    // CASO BASE - TERMINO
                    dcho = new Nodo(num);
                    return;
                }

                dcho.add(num);
            }
        }
    }



    Nodo primero;

    public BST() {
        primero = null;
    }

    @Override
    public void add(int num) {
        if (primero == null) {
            // Primer nodo vacio -> guardo num en él
            primero = new Nodo(num);
        }
        else {
            // Primer nodo lleno -> ¿dónde?
            // Le voy a trasladar la responsabilidad a cada nodo
            // El arbol BST le ordena al nodo que meta un valor en sus hijos
            primero.add(num);
        }
    }

    @Override 
    public boolean buscar(int num) {

        return false;
    }

    @Override
    public String toString() {
        return primero.toString();
    }
}
