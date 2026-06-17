package estructuras;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class GrafoDirigidoConPesos {

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
}


