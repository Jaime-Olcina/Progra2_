import java.util.Random;

public class Analizador {

     public static int[] generarArray(int n) {

            Random Randomizador = new Random();

            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = Randomizador.nextInt(100000);
            }

            return array;
        }

        public static long comparacionesTeoricas(int n) {

            return (n*(n-1))/2;
        }

        public static long medirBubble(int[] array) {

            long inicio = System.nanoTime();

            BubbleSort.bubbleSort(array);

            return System.nanoTime() - inicio;
        }

        public static long medirSelection(int[] array) {

            long inicio = System.nanoTime();

            SelectionSort.selectionSort(array);

            return System.nanoTime() - inicio;
        }
}
