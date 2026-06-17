
import estructuras.GrafoDirigido;
import estructuras.GrafoDirigidoConPesos;
import estructuras.GrafoNoDirigido;
import estructuras.GrafoNoDirigidoConPesos;

public class App {
    public static void main(String[] args) throws Exception {
        
        GrafoDirigido grafo = new GrafoDirigido();

        //    A
        //   / \
        //  v   v
        // C --> B
        // |     |
        // v     v
        // D --> E

        // AÑADIR UN NODO NUEVO - Añado "A" y le doy la posibilidad de tener conexiones
        grafo.addNodo("A");
        // AÑADIR UN NODO NUEVO - Añado "B" y le doy la posibilidad de tener conexiones
        grafo.addNodo("B");
        // AÑADIR UN NODO NUEVO - Añado "C" y le doy la posibilidad de tener conexiones
        grafo.addNodo("C");
        // AÑADIR UN NODO NUEVO - Añado "D" y le doy la posibilidad de tener conexiones
        grafo.addNodo("D");
        // AÑADIR UN NODO NUEVO - Añado "R" y le doy la posibilidad de tener conexiones
        grafo.addNodo("E");


        //grafo.getConexionesNodo("A"); ARRAYLIST DE CONEXIONES DE "A"
        grafo.addConexion("A", "B");
        grafo.addConexion("A", "C");

        //grafo.getConexionesNodo("B"); ARRAYLIST DE CONEXIONES DE "B"
        grafo.addConexion("B", "E");

        //grafo.getConexionesNodo("C"); ARRAYLIST DE CONEXIONES DE "C"
        grafo.addConexion("C", "B");
        grafo.addConexion("C", "D");
        
        //grafo.getConexionesNodo("D"); ARRAYLIST DE CONEXIONES DE "D"
        grafo.addConexion("D", "E");
        

        //grafo.borrarNodo("C");

        System.out.println(grafo.BFS("A"));

    }
}
