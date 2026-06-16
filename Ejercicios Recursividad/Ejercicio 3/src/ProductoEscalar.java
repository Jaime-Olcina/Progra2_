public class ProductoEscalar {
    public static int ProductoEsc(int[] v1, int[] v2, int indice) {

        // Caso base
        if (indice == v1.length) {
            return 0;
        }

        // Caso recursivo
        return v1[indice] * v2[indice]
                + ProductoEsc(v1, v2, indice + 1);
    }

}
