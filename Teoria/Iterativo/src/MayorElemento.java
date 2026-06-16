public class MayorElemento {
    public static int buscarMayor(int[] lista) {

        int m = lista[0];

        for (int p = 1; p < lista.length; p++) {

            if (lista[p] > m) {
                m = lista[p];
            }

        }

        return m;
    }
}

