
import java.util.TreeMap;
import java.util.TreeSet;


public class App {
    public static void main(String[] args) throws Exception {
        
        BST<Producto> arbol = new BST<>();

        arbol.insert(new Producto(0, "vigas", 15));
        arbol.insert(new Producto(5, "cemento", 210));
        arbol.insert(new Producto(2, "acero", 30));

        arbol.inOrder();



        BST<Integer> arbol2 = new BST<>();

        arbol2.insert(3);
        arbol2.insert(12);
        arbol2.insert(412);

        arbol2.inOrder();


        BST<String> arbol3 = new BST<>();

        arbol3.insert("3");
        arbol3.insert("metal");
        arbol3.insert("viga");

        arbol3.inOrder();
        System.out.println(arbol3.altura());

        TreeSet<Producto> tree = new TreeSet<>();
        tree.add(new Producto(0, "vigas", 15));
        tree.add(new Producto(5, "cemento", 210));
        tree.add(new Producto(2, "acero", 30));

        System.out.println(tree);

        TreeMap<Integer, Producto> tree4 = new TreeMap<>();

        Producto p1 = new Producto(0, "vigas", 15);
        Producto p2 = new Producto(5, "cemento", 210);
        Producto p3 = new Producto(2, "acero", 30);

        tree4.put(p1.getId(), p1);
        tree4.put(p2.getId(), p2);
        tree4.put(p3.getId(), p3);

        System.out.println(tree4);
    }
}


