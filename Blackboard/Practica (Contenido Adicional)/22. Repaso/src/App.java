import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        /*Grafo g = new Grafo();

        g.addNodo("A");
        g.addNodo("B");
        g.addNodo("C");
        g.addNodo("D");
        g.addNodo("E");


        g.addConexion("A", "B", 2);
        g.addConexion("A", "C", 1);
        g.addConexion("A", "D", 3);
        g.addConexion("B", "C", 3);
        g.addConexion("B", "D", 4);
        g.addConexion("C", "D", 1);
        g.addConexion("A", "E", 11231);
        g.addConexion("B", "E", 123);
        g.addConexion("C", "E", 2);

        g.caminoMasCorto("A", "E");*/


        BST arbol = new BST();

        arbol.add(1);
        arbol.add(45);
        arbol.add(2);

        arbol.preorder();
    }

}
