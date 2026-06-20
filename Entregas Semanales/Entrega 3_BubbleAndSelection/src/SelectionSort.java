public class SelectionSort {
    private static int minDesde(int[] array, int primero) {

        int val_min = array[primero];
        int pos_min = primero;

        for (int i = primero + 1; i < array.length; i++) {

            if (array[i] < val_min) {
                val_min = array[i];
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
}

