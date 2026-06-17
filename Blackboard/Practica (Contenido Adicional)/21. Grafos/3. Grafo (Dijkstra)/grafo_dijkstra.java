
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String args[]) {
        
       
        
        
        GrafoDirigidoConPesos g = new GrafoDirigidoConPesos();
        
        g.addNodo("A");
        g.addNodo("B");
        g.addNodo("C");
        g.addNodo("D");
        g.addNodo("E");
        g.addNodo("F");
        
        g.addConexion("A", "B", 3);
        g.addConexion("A", "C", 4);
        
        g.addConexion("B", "D", 2);
        g.addConexion("B", "E", 4);
        g.addConexion("B", "F", 1);
        
        g.addConexion("C", "B", 3);
        g.addConexion("C", "D", 1);
        
        g.addConexion("D", "E", 2);
        
        g.addConexion("F", "E", 2);
        

        
        System.out.println(g.caminoMasCortoANodo("A", "E"));
        
    }
}

class GrafoDirigidoConPesos {

    class Conexion {
        public String destino;
        public int peso;
        public Conexion(String destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
        @Override
        public String toString() {
            return "{" + destino + ", " + peso + "}";
        }
        @Override
        public boolean equals(Object o) {
            Conexion otro_nodo = (Conexion) o;
            return otro_nodo.destino.equals(this.destino);
        }
    }
    

        //   Nodo            Nodo     Peso - Lo que cuesta atravesar una conexion (tiempo, distancia)
        //  Origen          Destino 
    HashMap<String, HashMap<String, Integer>> grafo;
    
    public GrafoDirigidoConPesos() {
        this.grafo = new HashMap<>();
    }

    public void addNodo(String nodo) { // YA NO ES UNA LISTA, ES UN MAPA    
        if (nodo == null) return;

        // OPCION A
        grafo.putIfAbsent(nodo, new HashMap<>()); // AÑADIR NODO Y POSIBILIDAD DE CONEXIONES

        // OPCION B
        //if (!grafo.containsKey(nodo)) {
        //    grafo.put(nodo, new ArrayList<>()); // AÑADIR NODO Y POSIBILIDAD DE CONEXIONES
        //}
    }

    //  AHORA TAMBIEN NECESITAMOS EL PESO - TODAS LAS CONEXIONES TIENEN PESO    
    // AL poner put() añade y modifica. Si pongo putIfAbsent, debería hacer una función para modificar
    public void addConexion(String origen, String destino, Integer peso) { // CUIDADO QUE AHORA ES PUT, POR SER HASHMAP
        if (origen == null || destino == null) return;

        if(grafo.containsKey(origen) && grafo.containsKey(destino)) { 
            // EVITAR null.add() y EVITAR conexiones a nodos no añadidos aún
            grafo.get(origen).put(destino, peso); // AÑADIR CONEXION de origen a destino con peso
        }
    }


    public boolean borrarNodo(String nodo) { // IDENTICO
        if (nodo == null) return false;

        if(grafo.containsKey(nodo)) {
            //grafo.keySet(); NODOS - Keys son la primera columna, donde están los nodos
            //grafo.values(); LISTAS DE CONEXIONES - Values son la segunda columna, donde están las conexiones

            for(String elem : grafo.keySet()) { // ITERAR POR TODOS LOS NODOS
                borrarConexion(elem, nodo);
            }

            grafo.remove(nodo);

            return true;
        }

        return false;
    }


    public boolean borrarConexion(String origen, String destino) {
        if (origen == null || destino == null) return false;

        if(grafo.containsKey(origen) && grafo.containsKey(destino)) { 
            // devuelve el peso si existe la conexion y la borra -> true
            // devuelve null si no habia conexion
            return grafo.get(origen).remove(destino) != null; // si no es null, algo habré borrado
        }

        return false;
    }

    @Override
    public String toString() {
        String result = "";
        for(String nodo : grafo.keySet()) { // ITERAR POR TODOS LOS NODOS
            result += nodo + " -> " + grafo.get(nodo) + "\n";
        }
        return result;
    }

    public boolean isEmpty() {
        return grafo.size() > 0;
    }

    public List<String> getNodos() {
        return new ArrayList<>( grafo.keySet() );
    }

    public List<String> getConexionesNodo(String nodo) { // Como ya no devuelvo List, tengo que convertir a lista el set de los destinos
        return new ArrayList<>( grafo.get(nodo).keySet() ); // get nodo -> conexiones de ese nodo
    }

    public boolean existeConexion(String origen, String destino) { // Contains -> containsKey
        if(origen == null) return false;
        return grafo.get(origen).containsKey(destino);

        //return (origen == null) ? false : grafo.get(origen).contains(destino);
    }


    // Breadth - First - Search : usa una cola para recorrer los nodo más cercanos primero
     //no hay primero como en el árbol, por tanto, me tienes que decir el origen de la busqueda
    public List<String> BFS(String origen) { // CASI IDENTICO - Cambiar ArrayList por Hashmap - Mirar el bucle for
        if(!grafo.containsKey(origen)) return null;

        // Cola con nodos - String
        LinkedList<String> cola = new LinkedList<>();
        ArrayList<String> nodos_visitados = new ArrayList<>();

        cola.add(origen); // Empiezo en origen

        while(!cola.isEmpty()) {
            // Obtengo el siguiente a visitar
            String sig = cola.poll();

            // Apunto que lo he visitado
            nodos_visitados.add(sig);

            // Añadir nodos a visitar después: ¿cuáles?
            // Respuesta: Las conexiones de A... QUE NO HAYA VISITADO YA
            //grafo.get(sig); // conexiones del nodo sig - HashMap en este caso
            for (String elem : grafo.get(sig).keySet()) { // añado keyset()
                //cola.add(elem); // MAL - no estamos mirando si esta visitado o no

                if(!nodos_visitados.contains(elem) && !cola.contains(elem)) { // Si aun no lo he visitado
                    cola.add(elem); // Me lo anoto para visitarlo ahora
                }
            }
        }

        return nodos_visitados;
    }


    // Depth - First - Search : usa una pila para recorrer los nodo más lejanos primero
     //no hay primero como en el árbol, por tanto, me tienes que decir el origen de la busqueda
    public List<String> DFS(String origen) {
        if(!grafo.containsKey(origen)) return null;

        // Pila con nodos - String
        Stack<String> pila = new Stack<>(); // CAMBIO LinkedList -> Stack
        ArrayList<String> nodos_visitados = new ArrayList<>();

        pila.add(origen); // Empiezo en origen

        while(!pila.isEmpty()) {
            // Obtengo el siguiente a visitar
            String sig = pila.pop(); // CAMBIO poll -> pop

            // Apunto que lo he visitado
            nodos_visitados.add(sig);

            // Añadir nodos a visitar después: ¿cuáles?
            // Respuesta: Las conexiones de A... QUE NO HAYA VISITADO YA
            //grafo.get(sig); // conexiones del nodo sig - ArrayList en este caso
            for (String elem : grafo.get(sig).keySet()) {
                //pila.add(elem); // MAL - no estamos mirando si esta visitado o no

                if(!nodos_visitados.contains(elem) && !pila.contains(elem)) { // Si aun no lo he visitado
                    pila.add(elem); // Me lo anoto para visitarlo ahora
                }
            }
        }

        return nodos_visitados;
    }
    
    
    public void caminoMasCortoTodosNodos(String origen) {
        if(origen == null) return;
        
         PriorityQueue<Conexion> cola = new PriorityQueue<>(
            (x,y) -> x.peso - y.peso);
        
        cola.add(new Conexion("A", 0));
 
 
 
        // SETUP - vectores a usar
        ArrayList<String> lista_nodos = (ArrayList<String> )getNodos();

        ArrayList<Integer> distancias = new ArrayList<>();
        ArrayList<Boolean> visitado = new ArrayList<>();
        ArrayList<String> nodo_anterior = new ArrayList<>();
        
        // distnacias infinitas excepto para origen, todo false en visitado, y todo "-" en nodo anterior
        for(String nodo : lista_nodos) {
            if(nodo.equals(origen)) {
                distancias.add(0);
            } else {
                distancias.add(Integer.MAX_VALUE);
            }
            
            visitado.add(false);
            nodo_anterior.add("-");
        }
        // CHECK
        System.out.println(lista_nodos);
        System.out.println(distancias);
        System.out.println(visitado);
        System.out.println(nodo_anterior);
        
        
        while(!cola.isEmpty()) {
            System.out.println(cola);
            String nodo = cola.poll().destino;
            System.out.println(nodo);
            
            //Leer conexiones del nodo visitado    
            HashMap<String, Integer> conexiones_nodo = grafo.get(nodo);
            
            //ACTUALIZAR VISITADOS
            visitado.set( lista_nodos.indexOf(nodo) , true);
            
            //ACTUALIZAR DISTANCIAS
            for(String destino : conexiones_nodo.keySet()) {
                int peso = grafo.get(nodo).get(destino);
                
                // SI la distancia guardada a mi destino es más grande que la que puedo tomar ahora de nodo a destino, la sustituyo
                if(distancias.get( lista_nodos.indexOf(destino)) > distancias.get( lista_nodos.indexOf(nodo)) + peso) {
                    //sustituyo la distancia
                    distancias.set(lista_nodos.indexOf(destino), distancias.get( lista_nodos.indexOf(nodo)) + peso);
                    
                    // y me apunto de donde vengo para llegar
                    nodo_anterior.set( lista_nodos.indexOf(destino), nodo );
                }
            }
            
            
            //Meter conexiones del nodo visitado en cola    
            for(String elem : conexiones_nodo.keySet()) {
                if(visitado.get( lista_nodos.indexOf(elem)) == false && !cola.contains( new Conexion(elem, 0) )) // ES un nodo no visitado y el nodo no está (ignorando el peso por equals de Conexion)
                
                    cola.add( new Conexion(elem, distancias.get( lista_nodos.indexOf(elem) ) ) );
            }
            
            
            // CHECK
            System.out.println(lista_nodos);
            System.out.println(distancias);
            System.out.println(visitado);
            System.out.println(nodo_anterior);
            System.out.println();
        }
    }
    
    public int caminoMasCortoANodo(String origen, String destino_final) {
        if(origen == null) return -1;
        
         PriorityQueue<Conexion> cola = new PriorityQueue<>(
            (x,y) -> x.peso - y.peso);
        
        cola.add(new Conexion("A", 0));
 
 
 
        // SETUP - vectores a usar
        ArrayList<String> lista_nodos = (ArrayList<String> )getNodos();

        ArrayList<Integer> distancias = new ArrayList<>();
        ArrayList<Boolean> visitado = new ArrayList<>();
        ArrayList<String> nodo_anterior = new ArrayList<>();
        
        // distnacias infinitas excepto para origen, todo false en visitado, y todo "-" en nodo anterior
        for(String nodo : lista_nodos) {
            if(nodo.equals(origen)) {
                distancias.add(0);
            } else {
                distancias.add(Integer.MAX_VALUE);
            }
            
            visitado.add(false);
            nodo_anterior.add("-");
        }
        // CHECK
        System.out.println(lista_nodos);
        System.out.println(distancias);
        System.out.println(visitado);
        System.out.println(nodo_anterior);
        
        
        while(!cola.isEmpty()) {
            System.out.println(cola);
            String nodo = cola.poll().destino;
            System.out.println(nodo);
            
            //Leer conexiones del nodo visitado    
            HashMap<String, Integer> conexiones_nodo = grafo.get(nodo);
            
            //ACTUALIZAR VISITADOS
            visitado.set( lista_nodos.indexOf(nodo) , true);
            
            //ACTUALIZAR DISTANCIAS
            for(String destino : conexiones_nodo.keySet()) {
                int peso = grafo.get(nodo).get(destino);
                
                // SI la distancia guardada a mi destino es más grande que la que puedo tomar ahora de nodo a destino, la sustituyo
                if(distancias.get( lista_nodos.indexOf(destino)) > distancias.get( lista_nodos.indexOf(nodo)) + peso) {
                    //sustituyo la distancia
                    distancias.set(lista_nodos.indexOf(destino), distancias.get( lista_nodos.indexOf(nodo)) + peso);
                    
                    // y me apunto de donde vengo para llegar
                    nodo_anterior.set( lista_nodos.indexOf(destino), nodo );
                }
            }
            
            
            //Meter conexiones del nodo visitado en cola    
            for(String elem : conexiones_nodo.keySet()) {
                if(visitado.get( lista_nodos.indexOf(elem)) == false && !cola.contains( new Conexion(elem, 0) )) // ES un nodo no visitado y el nodo no está (ignorando el peso por equals de Conexion)
                
                    cola.add( new Conexion(elem, distancias.get( lista_nodos.indexOf(elem) ) ) );
            }
            
            
            // CHECK
            System.out.println(lista_nodos);
            System.out.println(distancias);
            System.out.println(visitado);
            System.out.println(nodo_anterior);
            System.out.println();
        }
        return distancias.get( lista_nodos.indexOf(destino_final));
    }
}


