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

        boolean buscar(int num) {
            System.out.println("BUSQUEDA");
            if(this.valor == num) {
                // Si mi (this) valor es el numero a buscar, he terminado
                // caso base
                return true;
            }

            // para seguir cambio el nodo que busca - ahora es this
            if(num < this.valor)  {
                // buscar a la izquierda
                if(izq == null) {
                    // no hay un nodo a la izquierda - tiene que estar a la izq - no esta
                    return false;
                }
                // hay un nodo a la izquierda
                // this.buscar() -> this.izq.buscar()
                return this.izq.buscar(num);
            }          
            else {
                // buscar a la derecha
                if(dcho == null) {
                    // no hay un nodo a la derecha - tiene que estar a la dcha - no esta
                    return false;
                }
                // hay un nodo a la derecha
                // this.buscar() -> this.dcho.buscar()
                return this.dcho.buscar(num);
            }   
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
        if(primero == null) {
            return false;
        }
        else {
            return primero.buscar(num);
        }
    }

    @Override
    public String toString() {
        return primero.toString();
    }
}
