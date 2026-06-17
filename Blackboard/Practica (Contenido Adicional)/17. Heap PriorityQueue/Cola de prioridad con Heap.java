import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ColaDePrioridad<String> cola = new ColaDePrioridad<>();
        
        cola.add("test1");
        cola.add("test2", 32);
        cola.add("test3", 5);
        cola.add("test4", 41);
        cola.add("test5", 15);
        cola.add("test6", 12);
        
        System.out.println(cola.poll());
        System.out.println(cola.poll());
        System.out.println(cola.poll());
        System.out.println(cola.poll());
        System.out.println(cola.poll());
        System.out.println(cola.poll());
        System.out.println(cola.poll());
        
        System.out.println(cola);
    }

}

interface IColaDePrioridad<T> {
    public T poll();
    public void add(T t);
    public void add(T t, int prioridad);
    
    public int size();
    public T peek();
}

class ColaDePrioridad<T> implements IColaDePrioridad<T> {
    // mayor a menor porque la prioridad 0 va a ser la mas baja
    class Elemento<T> {
        T dato;
        int prioridad;
        
        public Elemento (T dato) {
            this.dato = dato;
            this.prioridad = 0;
        }
        
        public Elemento (T dato, int prioridad) {
            this.dato = dato;
            this.prioridad = prioridad;
        }
        
        @Override
        public String toString() {
            return "[" + dato + ", " + prioridad + "]";
        }
    }
    
    
    ArrayList<Elemento<T>> array;
    
    public ColaDePrioridad() {
        this.array = new ArrayList<>();
        array.add(new Elemento(null));
    }
    
    @Override
    public T poll() {
        if(array.size() > 2) {
            T dato_a_entregar = array.get(1).dato;
            //array.remove(1); // mal, porque el elemento 2º pasa a ser el nuevo 1º, pero quiero que el nuevo 1º sea el ultimo de todos, no el 2º
            
            swap(1, array.size()-1);
            array.remove(array.size()-1);
            
            // y ahora a comprobar que el heap sea valido - que el nuevo 1º sea mayor o igual que sus hijos, en un while
            
            int indice_padre = 1;
            int indice_hijo1 = indice_padre * 2;
            int indice_hijo2 = indice_padre * 2 + 1;
            
            // comprobacion de que son indices no-fuera-del-array
            if(indice_hijo1 >= array.size()) {
                indice_hijo1 = indice_padre;
            }
            if(indice_hijo2 >= array.size()) {
                indice_hijo2 = indice_padre;
            }
            
            while (array.get(indice_padre).prioridad < array.get(indice_hijo1).prioridad || array.get(indice_padre).prioridad < array.get(indice_hijo2).prioridad) {
                
                if(array.get(indice_hijo1).prioridad > array.get(indice_hijo2).prioridad) {
                    // como el hijo1 tiene mayor prioridad, va arriba, donde el padre
                    swap(indice_padre, indice_hijo1);
                    indice_padre = indice_hijo1;
                } else {
                    swap(indice_padre, indice_hijo2);
                    indice_padre = indice_hijo2;
                }
                
                indice_hijo1 = indice_padre*2;
                indice_hijo2 = indice_padre*2+1;
                
                // comprobacion de que son indices no-fuera-del-array
                if(indice_hijo1 >= array.size()) {
                    indice_hijo1 = indice_padre;
                }
                if(indice_hijo2 >= array.size()) {
                    indice_hijo2 = indice_padre;
                }
            }
            
            return dato_a_entregar;
        }
        else if (array.size() == 2) {
            T dato_a_entregar = array.get(1).dato;
            array.remove(1);
            
            return dato_a_entregar;
        } else {
            return null;
        }
    }
    
    @Override
    public void add(T t) {
        // anyadir elemento al final. Prioridad va a ser 0 - va a ser ultimo
        array.add(new Elemento(t));
    }
    
    @Override
    public void add(T t, int prioridad) {
        // anyadir elemento al final. Prioridad puede ser la mas grande, asi que hay que ver si es valido el heap - padre mayor o igual que sus hijos
        
        // O(log_2(N))
        int indide_hijo = array.size();
        int indice_padre = indide_hijo/2;
        
        array.add(new Elemento(t, prioridad));
        
        while(array.get(indice_padre).prioridad < array.get(indide_hijo).prioridad && indide_hijo > 1) {
            
            swap(indice_padre, indide_hijo);
            indide_hijo = indice_padre;
            indice_padre = indide_hijo / 2;
        }
    }
    
    @Override
    public int size() {
        return array.size() - 1;
    }
    
    @Override
    public T peek() {
        if (array.size() >= 2) {
            return array.get(1).dato;
        } else {
            return null;
        }
    }
    
    public void swap(int i, int j) {
        Elemento elem_j = array.get(j);
        array.set(j, array.get(i));
        array.set(i, elem_j);
    }
    
    @Override
    public String toString() {
        return array.toString();
    }
}