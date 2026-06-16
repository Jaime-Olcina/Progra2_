public class Main {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        Ascendente.ImprimirAscendente(x);
        Descendente.ImprimirDescendente(y);
    }
}