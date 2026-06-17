import java.util.ArrayList;
import java.util.ArrayDeque; // por variar. Se podria usar LinkedList

class Main {
    public static void main(String[] args) {
        BST arbol = new BST();

        arbol.add(4);
        arbol.add(1);
        arbol.add(6);
        arbol.add(5);
        arbol.add(2);
        arbol.add(3);

        //arbol.borrar(4);

        System.out.println(arbol.getBFS());
    }
}



interface IBST {
    public boolean buscar(int num);

    public void add(int num);

    public boolean borrar(int num);
}

class BST implements IBST {
    
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

     //nuevo_hijo
     //   |
    //    v
        Nodo borrar(Nodo padre, int num) {
            if(padre == null) {
                return padre;
            }
            
            if(num < padre.valor) {
                //clave
                // hay que cambiar o no la izq
                padre.izq = borrar(padre.izq, num); // DA O NULL O PADRE.IZQ
            }
            else if(num > padre.valor) {
                //clave
                // hay que cambiar o no la izq
                padre.dcho = borrar(padre.dcho, num); // DA O NULL O PADRE.IZQ
            }
            else {
                // num es mi padre.valor
                
                // Tres casos - padre tiene 0, 1, 2 hijos
                if(padre.izq == null) { // si falta un hijo, tiene o 0 o 1
                    return padre.dcho; // el de la dcha es o null o un nodo. Si es null, no pasa nada, porque ahora al borrar queda null. Si es un nodo, tampoco pasa nada, porque ahora queda ese nodo como nuevo hijo del padre anterior
                }
                if(padre.dcho == null) { 
                    return padre.izq;
                }
                
                // aqui ninguno es null -> 2 hijos
                // tengo que calcular el anterior o el sucesor
                Nodo sig = getSiguiente(padre);
                
                //Intercambio de valores
                padre.valor = sig.valor; // Hay dos nodos con el valor del siguiente
                padre.dcho = borrar(padre.dcho, sig.valor); // Borro el otro (sig.valor), que esta en la rama derecha 
            }
            return padre;
        }
        
        Nodo getSiguiente(Nodo padre) {
            //1er paso - ir a dcha
            Nodo sig = padre.dcho;
            while(sig != null && sig.izq != null) {
                sig = sig.izq;
            }
            return sig;
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
    
    public ArrayList<Integer> getBFS() {
        if(primero == null) return new ArrayList<>();

        ArrayList<Integer> recorrido = new ArrayList<>();
        ArrayDeque<Nodo> nodos_a_visitar = new ArrayDeque<>();
        
        nodos_a_visitar.add(primero);
        
        // Debo seguir mientras haya nodos a visitar
        while(! nodos_a_visitar.isEmpty()) {
            
            Nodo sig = nodos_a_visitar.poll();
            recorrido.add(sig.valor);
            
            if(sig.izq != null)
                nodos_a_visitar.add(sig.izq);
            if(sig.dcho != null)
                nodos_a_visitar.add(sig.dcho); 
        }
        
        return recorrido;
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

        primero.borrar(primero, num);
        return true;
    }

    @Override
    public String toString() {
        return primero.toString();
    }
}
