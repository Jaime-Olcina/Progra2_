import estructuras.BST;

public class App {
    public static void main(String[] args) throws Exception {
        BST arbol = new BST();

        arbol.add(4);
        arbol.add(1);
        arbol.add(5);
        arbol.add(2);
        arbol.add(3);

        arbol.borrar(4);

        System.out.println(arbol);
    }
}
