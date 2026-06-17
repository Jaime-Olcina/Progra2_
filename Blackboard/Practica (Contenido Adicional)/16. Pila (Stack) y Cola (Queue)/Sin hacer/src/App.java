import estructuras.*;

public class App {
    public static void main(String[] args) throws Exception {

        Pila<Integer> p = new Pila<>();
        p.push(3);
        p.push(1);
        p.push(6);
        p.push(312);

        p.pop();

        System.out.println(p);
    }
}
