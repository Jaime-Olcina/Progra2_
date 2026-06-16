public class Descendente {
    public static void ImprimirDescendente(int n) {

        if (n == 0)
            return;

        System.out.println(n);

        ImprimirDescendente(n - 1);

    }
}
