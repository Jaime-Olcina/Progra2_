package estructuras;

import java.util.List;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;




public class Grafo {

    HashMap<String, List<String>> grafo;
    
    public Grafo() {
        this.grafo = new HashMap<>();
    }

    public void addNodo(String nodo) {
        if (nodo == null) return;

        // OPCION A
        grafo.putIfAbsent(nodo, new ArrayList<>()); // AÑADIR NODO Y POSIBILIDAD DE CONEXIONES

        // OPCION B
        //if (!grafo.containsKey(nodo)) {
        //    grafo.put(nodo, new ArrayList<>()); // AÑADIR NODO Y POSIBILIDAD DE CONEXIONES
        //}
    }

    public void addConexion(String origen, String destino) {
        if (origen == null || destino == null) return;

        if(grafo.containsKey(origen) && grafo.containsKey(destino)) { 
            // EVITAR null.add() y EVITAR conexiones a nodos no añadidos aún
            grafo.get(origen).add(destino); // AÑADIR CONEXION de origen a destino
        }
    }


    public boolean borrarNodo(String nodo) {
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
            return grafo.get(origen).remove(destino);
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

}


