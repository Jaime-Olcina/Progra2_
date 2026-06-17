public class App {
    public static void main(String[] args) throws Exception {

        int[] array = {1, 7, 9, 4, 6, 5, 10, 2, 3, 8};

        array = bubbleSort(array);

        for (int elem : array) {
            System.out.println(elem);
        }
        
    }

    public static int minDesde(int[] array, int primero) {
        int min = array[primero];
        int pos_min = primero;

        for (int i = primero; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
                pos_min = i;
            }
        }
        return pos_min;
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos_min = minDesde(array, i);
            int aux = array[i];
            array[i] = array[pos_min];
            array[pos_min] = aux;
        }

        return array;
    }


    public static int[] bubbleSort(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if(array[j] > array[j+1]) {
                    int aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }
            
        }

        return array;
    }


}
