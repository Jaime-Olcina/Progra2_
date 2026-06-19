import estructuras.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        ListaEnlazada ll = new ListaEnlazada();
        ll.anyadir(1);
        ll.anyadir(1);
        ll.anyadir(17);
        ll.anyadir(4);
        ll.anyadir(5);
        ll.anyadir(1,6);
        ll.anyadir(1);
        ll.anyadir(23);
        ll.anyadir(0);
        ll.anyadir(6);
        ll.anyadir(7);
        System.out.println(ll.acceder(0));

        for (int i = 0; i < 10; i++) {
            System.out.println(ll.acceder(i));
        }
    }
}
