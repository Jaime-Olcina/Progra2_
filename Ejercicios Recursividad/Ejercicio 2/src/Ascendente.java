public class Ascendente {
    public static void ImprimirAscendente(int n) {

        if (n == 0)
            return;

        ImprimirAscendente(n - 1);

        System.out.println(n);
    }
}
