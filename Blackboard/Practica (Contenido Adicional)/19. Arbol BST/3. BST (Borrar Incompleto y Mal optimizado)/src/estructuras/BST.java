package estructuras;

import java.util.ArrayList;

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
            String subarbol = "";
            subarbol += " " + String.valueOf(valor);

            if(izq != null) {
                subarbol += " " + izq.toString();
            }

            if(dcho != null) {
                subarbol += " " + dcho.toString();
            }

            return subarbol;
        }

        public ArrayList<Integer> getInorder(ArrayList<Integer> orden) {
            //izq
            if(izq != null) {
                izq.getInorder(orden);
            }

            //centro
            orden.add(valor);

            //dcha
            if(dcho != null) {
                dcho.getInorder(orden);
            }

            return orden;
        }

        boolean buscar(int num) {
            //System.out.println("BUSQUEDA");
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

        Nodo buscarNodo(int num) {
            if(this.valor == num) {
                return this;
            }
            if(num < this.valor)  {
                if(izq == null) {
                    return null;
                }
                return this.izq.buscarNodo(num);
            }          
            else {
                if(dcho == null) {
                    return null;
                }
                return this.dcho.buscarNodo(num);
            }   
        }

        boolean borrar(Nodo nodo_a_borrar) {
            if (nodo_a_borrar == this) {
                return true; // el nodo sí soy yo
            }
            // el nodo no soy yo
            if(nodo_a_borrar.valor < this.valor) {
                if(izq.borrar(nodo_a_borrar)) { // toca borrar izq
                    if(izq.izq == null && izq.dcho == null) {
                        izq = null;
                    }
                    else if(izq.izq == null) { // si el hijo a borrar tiene un numero a la dcha
                        izq = izq.dcho; // intercambio
                    }
                    else if(izq.dcho == null) {
                        izq = izq.izq;
                    }
                }
            }
            else {
                if(dcho.borrar(nodo_a_borrar)) { // toca borrar dcho
                    if(dcho.izq == null && dcho.dcho == null) {
                        dcho = null;
                    }
                    else if(dcho.izq == null) { // si el hijo a borrar tiene un numero a la dcha
                        dcho = dcho.dcho; // intercambio
                    }
                    else if(dcho.dcho == null) {
                        dcho = dcho.izq;
                    }
                }
            }
            return false; // el nodo no soy yo
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

    public ArrayList<Integer> getInorder() {
        if(primero == null) return new ArrayList<>();
        return primero.getInorder(new ArrayList<>());
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
        return primero.buscar(num);
    }

    @Override 
    public boolean borrar(int num) {
        if(primero == null) {
            return false;
        }

        Nodo nodo_a_borrar = buscarNodo(num);
        if(nodo_a_borrar == null) {
            return false;
        }

        primero.borrar(nodo_a_borrar);
        return true;
    }

    public Nodo buscarNodo(int num) {
        if(primero == null) {
            return null;
        }
        else {
            return primero.buscarNodo(num);
        }
    }

    @Override
    public String toString() {
        return primero.toString();
    }
}
