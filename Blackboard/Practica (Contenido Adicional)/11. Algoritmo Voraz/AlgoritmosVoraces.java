import java.util.ArrayList;

public class AlgoritmosVoraces {
    
    public static void main(String[] args) {
        int[] V = {1, 4, 7, 8, 10};
        int[] W = {1, 2, 6, 10, 7};

        int C = 12;

        //mochila(V, W, C);


        int[] camino = {1, 3, 2, 3, 1, 3, 2, 2, 1, 3, 2, 3, 1};
        System.out.println(minSaltos(camino));

    }

    public static int mochila(int V[], int W[], int C) {
        // Compr. seguridad
        if(V.length !=  W.length) {return -1;}

        // Memoria - variables a ir resolviendo
        int[][] beneficio = new int[V.length+1][C + 1];

        // Problema mas pequeño y evidente
        for(int i = 0; i < V.length + 1 ; i++) { beneficio[i][0] = 0; }
        for(int i = 0; i < C + 1 ; i++) { beneficio[0][i] = 0; }

        // Resolviendo problemas de menor a mayor con optimalidad de Bellmann
        for(int n_objetos = 1; n_objetos < V.length + 1 ; n_objetos++) {
            for (int capacidad = 1; capacidad < C + 1 ; capacidad++){

                int valor_total = 0;
                for(int k = 0; k < n_objetos; k++) {
                    valor_total += V[k];
                }
                System.out.println(valor_total);

                // Si no cabe
                if(W[n_objetos - 1] > capacidad) {
                    // No se coge - que es como si no existiese (un objeto menos)
                    beneficio[n_objetos][capacidad] = beneficio[n_objetos-1][capacidad];
                }
                else {
                    // Sí que cabe - cogerlo o no cogerlo
                    int no_cogerlo = beneficio[n_objetos-1][capacidad];
                    int cogerlo = V[n_objetos-1] + beneficio[n_objetos][capacidad - W[n_objetos-1]];

                    beneficio[n_objetos][capacidad] = Math.min( Math.max(no_cogerlo, cogerlo), valor_total );

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

    public static int minSaltos(int[] array) {
        int num_saltos = 0;
        int posicion_actual = array.length - 1;
        
        while (posicion_actual > 0) {
            int i = 0;
            ArrayList<Integer> opciones = new ArrayList<>();
            while(array[posicion_actual - i] >= posicion_actual - i) {
                opciones.add(posicion_actual - i);
            }

            int min = Integer.MAX_VALUE;
            for(int j = 0; j < opciones.size(); j++) {
                if(opciones.get(j) < min) min = opciones.get(j);
            }

            posicion_actual = min;
            num_saltos++;
        }

        return num_saltos;
    }

}
