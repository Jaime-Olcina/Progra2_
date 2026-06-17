
import java.util.*;

public class Grafo {
    
    HashMap<String, HashMap<String, Integer>> grafo;

    public Grafo() {
        grafo = new HashMap<>();
    }

    public void addNodo(String nodo) {
        if (nodo == null) return;
        grafo.putIfAbsent(nodo, new HashMap<>());
    }
    
    public void addConexion(String origen, String destino, int peso) {
        if (origen == null || destino == null) return;
        if (!grafo.containsKey(origen) || !grafo.containsKey(destino) ) return;
        grafo.get(origen).put(destino, peso);
        //grafo.get(destino).put(origen, peso);
    }

    public List<String> caminoMasCorto(String origen, String destino) {

        // ~ PROGRAMACION DINAMICA (realmente voraz)

        ArrayList<String> nodos = new ArrayList<String>(grafo.keySet());
        ArrayList<Boolean> visitado = new ArrayList<Boolean>();
        ArrayList<Integer> distancias = new ArrayList<Integer>();
        ArrayList<String> anterior = new ArrayList<String>();

        // Inicializo - estado inicial

        for (int col = 0; col < nodos.size(); col++) {
            // add para añadir
            // set para modificar
            // get para leer
            // remove para borrar
            visitado.add(false);
            distancias.add(Integer.MAX_VALUE);
            anterior.add("-");
        }

        // el nodo origen tiene distancia 0 - modificacion - set
                                //col        valor
        distancias.set(nodos.indexOf(origen), 0);



                    //2 enteros, el primero es el indice del nodo, el segundo es el peso
        PriorityQueue<int[]> cola = new PriorityQueue<>((obj1, obj2) -> obj1[1] - obj2[1]); 
                                                            //pongo 1 porque el segundo es el peso
        
                        // indice            peso
        int array[] = {nodos.indexOf(origen), 0};
        cola.add( array );


        // Algoritmo - visitar nodos de la cola en orden de prioridad
        while(!cola.isEmpty()) {
            int sig_origen[] = cola.poll(); 
            
            int col_sig_origen = sig_origen[0];
            int peso_sig_origen = sig_origen[1];    
            
            visitado.set(col_sig_origen, true);
            //  distancias.get(col_sig) = lo que tardo en llegar a sig con la información hasta ahora

            // los destinos son las conexiones de mi sig_origen 
            HashMap<String, Integer> conexiones = grafo.get(nodos.get(col_sig_origen));

            for(String sig_destino_nombre : conexiones.keySet()) {

                int col_sig_destino = nodos.indexOf(sig_destino_nombre);
                int peso_sig_destino = conexiones.get(sig_destino_nombre);

                if(distancias.get(col_sig_destino) >  // si la distancia memorizada al destino es mayor que
                    distancias.get(col_sig_origen) +  // si la distancia memorizada más
                    peso_sig_destino) {               // el salto origen-destino

                        // el salto merece la pena - lo doy

                        // memorizo la nueva distancia
                        distancias.set(col_sig_destino, distancias.get(col_sig_origen) + peso_sig_destino);

                        // apunto el salto que he dado
                        anterior.set(col_sig_destino, nodos.get(col_sig_origen));
                }

                // Añadir nuevos posibles sig_origen
                // Tienen que ser no visitados y que no estén ya en la cola
                if(visitado.get(col_sig_destino) == false) {
                    int[] array_para_cola = {col_sig_destino, peso_sig_destino};
                    cola.add(array_para_cola);
                }
            }

        }
        

        System.out.println(nodos);
        System.out.println(visitado);
        System.out.println(distancias);
        System.out.println(anterior);

        String destino_camino = destino;
        ArrayList<String> camino = new ArrayList<>();

        camino.add(destino_camino);

        while (anterior.get( nodos.indexOf(destino_camino)) != "-" ) {
            String nodo_anterior = anterior.get( nodos.indexOf(destino_camino)) ;
            
            camino.add(0, nodo_anterior); // añadir al principio y no al final

            destino_camino = nodo_anterior;
        }


        System.out.println(camino);
        return camino;
    }


}
