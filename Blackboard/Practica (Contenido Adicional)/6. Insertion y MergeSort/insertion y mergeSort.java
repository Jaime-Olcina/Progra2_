
class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    
    public static void main(String[] args) {
        int[] array = {3,6,8,9,2,5,10,1,4,7};
        //insertionSort(array);
        mergeSort(array);
    
        
        for (int elem : array) {
            System.out.println(elem);
        }
        
    }
    
    // O(N²)
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while(array[j-1] > array[j]) {
                int aux = array[j];
                array[j] = array[j-1];
                array[j-1] = aux;
                j--;
                
                if (j == 0) break;
            }
        } 
    }
    
    // O(N * log_2(N))
    public static void mergeSort(int[] array) {
        merge(array, 0, array.length);
    }
    
    public static void merge(int[] array, int izq, int dcha) {
        if (dcha - izq <= 1) {
            return;
        }
        
        int medio = (izq + dcha) / 2;
        
        // Mitad izq
        int inicio_1 = izq;
        int voy_1 = izq;
        int final_1 = medio;
        
        // Mitad dcha
        int inicio_2 = medio;
        int voy_2 = medio;
        int final_2 = dcha;
        
        // Si no son de tamanyo 1, dividir más y ordenar sub-arrays
        merge(array, izq, medio);
        merge(array, medio, dcha);
        
        
        // SOLO VISUALIZACION (PARA VER EL PROCESO)
        // DESCOMENTAR PARA VERLO Y ENTENDERLO
        /*
        System.out.println("Ordenamos estos numeros:");
        for(int i = izq; i < dcha; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        
        
        System.out.println("Separamos en dos");
        for(int i = izq; i < medio; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("    ");
        for(int i = medio; i < dcha; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        */
        
        
        // Una vez se han ordenado, ordenar las mitades en un array temporal (para no modificar el original de momento)
        int[] array_temp = new int[dcha - izq];
        int voy_temp = 0;
        while(voy_1 < final_1 || voy_2 < final_2) {
            if (voy_1 >= final_1) { // Se ha acabado el array izquierdo
                array_temp[voy_temp] = array[voy_2];
                voy_2++;
            }
            else if (voy_2 >= final_2) { // Se ha acabado el array derecho
                array_temp[voy_temp] = array[voy_1];
                voy_1++;
            }
            else if (array[voy_1] <= array[voy_2]) {
                array_temp[voy_temp] = array[voy_1];
                voy_1++;
            }
            else {
                array_temp[voy_temp] = array[voy_2];
                voy_2++;
            }
            voy_temp++;
        }
        
        // Modificar el original ya ordenado
        voy_temp = 0;
        for (int i = izq; i < dcha; i++) {
            array[i] = array_temp[voy_temp];
            voy_temp++;
        }
        
        
        // SOLO VISUALIZACION (PARA VER EL PROCESO)
        // DESCOMENTAR PARA VERLO Y ENTENDERLO
        /*
        System.out.println("Mezclamos las mitades de forma ordenada:");
        for(int i = 0; i < array_temp.length; i++) {
            System.out.print(array_temp[i] + " ");
        }
        System.out.println();
        
        System.out.println("Y el original queda asi:");
        for(int i = 0; i < array.length; i++) {
            if(i >= izq && i < dcha) {
                System.out.print(ANSI_RED + array[i] + " ");
            }
            else {
                System.out.print(ANSI_RESET + array[i] + " ");
            }
        }
        System.out.println("\n\n\n");
        */
    } 
    
}







