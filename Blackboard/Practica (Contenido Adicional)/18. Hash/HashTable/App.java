import estructuras.HashTable;

public class App {
    public static void main(String[] args) throws Exception {
        
        HashTable ht = new HashTable();
        
        ht.add(3); // hash 3
        ht.add(7);
        ht.add(50);
        ht.add(103); // hash 3

        System.out.println(ht);



    }
}
