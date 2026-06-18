//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] tamaños = {100, 1000, 10000};

        System.out.printf("%-10s %-20s %-20s %-20s%n", "N", "Comparaciones", "Bubble(ns)", "Selection(ns)");

        for (int n : tamaños) {

            int[] original = Analizador.generarArray(n);

            int[] bubbleArray = original.clone();
            int[] selectionArray = original.clone(); //Si no se hace, el Selection ordena un array ya ordenado

            long comparaciones = Analizador.comparacionesTeoricas(n);

            long tiempoBubble = Analizador.medirBubble(bubbleArray);

            long tiempoSelection = Analizador.medirSelection(selectionArray);

            System.out.printf("%-10d %-20d %-20d %-20d%n", n, comparaciones, tiempoBubble, tiempoSelection);
        }
    }
}