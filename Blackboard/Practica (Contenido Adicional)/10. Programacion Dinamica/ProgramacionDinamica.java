import java.time.*;

public class ProgramacionDinamica {
    public static void main(String[] args) throws Exception {

        int[] V = {1, 4, 7, 8, 10};
        int[] W = {1, 2, 6, 10, 7};

        int C = 12;

        mochila(V, W, C);
    }

    public static int mochila(int V[], int W[], int C) {
        // Compr. seguridad
        if(V.length !=  W.length) {
            return -1;
        }

        // Memoria - variables a ir resolviendo
        int[][] beneficio = new int[V.length+1][C + 1];

        // Problema mas pequeño y evidente
        for(int i = 0; i < V.length + 1 ; i++) { beneficio[i][0] = 0; }
        for(int i = 0; i < C + 1 ; i++) { beneficio[0][i] = 0; }

        // Resolviendo problemas de menor a mayor con optimalidad de Bellmann
        for(int n_objetos = 1; n_objetos < V.length + 1 ; n_objetos++) {
            for (int capacidad = 1; capacidad < C + 1 ; capacidad++){
                // Si no cabe
                if(W[n_objetos - 1] > capacidad) {
                    // No se coge - que es como si no existiese (un objeto menos)
                    beneficio[n_objetos][capacidad] = beneficio[n_objetos-1][capacidad];
                }
                else {
                    // Sí que cabe - cogerlo o no cogerlo
                    int no_cogerlo = beneficio[n_objetos-1][capacidad];
                    int cogerlo = V[n_objetos-1] + beneficio[n_objetos][capacidad - W[n_objetos-1]];

                    beneficio[n_objetos][capacidad] = Math.max(no_cogerlo, cogerlo);
                }
            }
        }

        // Visualizacion (opcional)
        for(int n_objetos = 0; n_objetos < V.length + 1 ; n_objetos++) {
            for (int capacidad = 0; capacidad < C + 1 ; capacidad++){
                System.out.print(beneficio[n_objetos][capacidad] + "  ");
            }
            System.out.println();
        }

        // resultado final
        return beneficio[W.length][C];
    }


    public static int fibonacciBottomUp(int N) {
        // Memoria
        int[] memoria = new int[N+1];

        // Problema mas pequeño y evidente
        memoria[0] = 0;
        memoria[1] = 1;

        // Resolviendo problemas de menor a mayor
        for(int i = 2; i <= N; i++) {
            memoria[i] = memoria[i-1] + memoria[i-2];
        }

        // Resultado final
        return memoria[N];
    }



}
