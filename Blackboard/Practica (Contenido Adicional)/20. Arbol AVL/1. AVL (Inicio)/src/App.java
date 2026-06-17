public class App {
    public static void main(String[] args) throws Exception {
        
        AVL<Integer> arbol = new AVL<>();

        arbol.insert(3);
        arbol.insert(1);
        arbol.insert(2);
        arbol.inOrder();

    }
}
