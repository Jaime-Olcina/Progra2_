
import java.util.stream.*;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        //System.out.println(fibonacci(10));
        
        String[][] tuberia = {
            {"X","X"," ","X","X"},   
            {"X"," ","X","X"," "},
            {" ","X"," ","X","X"},
            {"X"," "," ","X"," "},
            {"X","X","X","X"," "},
            {"X"," "," ","X","X"},
            {" ","X","X"," ","X"},
        };
        
        System.out.println(vorazTuberia(tuberia));
    }
    public static int vorazTuberia(String[][] tuberia) {
        int mi_pos = 0;
        int total_distancia = 0;
        
        for(int nivel = 0; nivel < tuberia.length; nivel++){
            
            // opciones del algoritmo voraz
            ArrayList<Integer> opciones = new ArrayList<>();
            for(int caminos = 0; caminos < tuberia[nivel].length; caminos++) {
                if(tuberia[nivel][caminos].equals(" ")) {
                    opciones.add(caminos);
                }
            }
            
            System.out.println("Para el nivel "+ nivel + " tengo:");
            for(int elem : opciones) {
                System.out.print(elem + " ");
            }
            System.out.println();
            
            /// elegir opcion segun un max o min
            int mejor_opcion = -1;
            int min_distancia = Integer.MAX_VALUE;
            for(int opcion : opciones) {
                if(Math.abs(opcion - mi_pos) < min_distancia) {
                    min_distancia = Math.abs(opcion - mi_pos);
                    mejor_opcion = opcion;
                }
            }
            System.out.println("Mejor opcion: "+ mejor_opcion);
            total_distancia += Math.abs(mejor_opcion - mi_pos);
            mi_pos = mejor_opcion;
        }
        
        return total_distancia;
    }
    
    
    
    public static int fibonacci(int N) {
        int[] memoria = new int[N+1];
        memoria[0] = 0;
        memoria[1] = 1;

        IntStream.iterate( 2, (i) -> {
            System.out.println(i);
            return i + 1;
        }).limit(N-1).forEach((num) -> {
            memoria[num] = memoria[num-1] + memoria[num-2]; 
            //System.out.println(num);
        });
        
        for(int elem : memoria) {
            //System.out.println(elem);
        }
        
        return memoria[N];
    }
}