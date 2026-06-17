import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import estructuras.Grafo;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        Grafo grafo = new Grafo();

        //    A
        //   / \
        //  v   v
        // C --> B

        // AÑADIR UN NODO NUEVO - Añado "A" y le doy la posibilidad de tener conexiones
        grafo.addNodo("A");
        // AÑADIR UN NODO NUEVO - Añado "B" y le doy la posibilidad de tener conexiones
        grafo.addNodo("B");
        // AÑADIR UN NODO NUEVO - Añado "C" y le doy la posibilidad de tener conexiones
        grafo.addNodo("C");


        //grafo.get("A"); ARRAYLIST DE CONEXIONES DE "A"
        grafo.addConexion("A", "B");
        grafo.addConexion("A", "C");

        //grafo.get("B"); ARRAYLIST DE CONEXIONES DE "B"

        //grafo.get("C"); ARRAYLIST DE CONEXIONES DE "C"
        grafo.addConexion("C", "B");

        grafo.borrarNodo("C");

        System.out.println(grafo);

    }
}
