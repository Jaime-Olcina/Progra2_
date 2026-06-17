import estructuras.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        ListaEnlazada ll = new ListaEnlazada();
        ll.anyadir(0);
        ll.anyadir(1);
        System.out.println(ll.acceder(0));
    }




}
