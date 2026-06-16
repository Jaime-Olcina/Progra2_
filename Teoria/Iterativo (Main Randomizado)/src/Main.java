import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        // Crear lista aleatoria
        int[] numeros = new int[10];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100) + 1; // 1 a 100
        }

        System.out.print("Lista: ");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println();

        // Buscar mayor
        int mayor = MayorElemento.buscarMayor(numeros);
        System.out.println("Mayor: " + mayor);

        // Número aleatorio para factorial
        int numeroFactorial = random.nextInt(10) + 1; // 1 a 10

        System.out.println("Número para factorial: " + numeroFactorial);

        int factorial = Factorial.calcular(numeroFactorial);

        System.out.println("Factorial: " + factorial);
    }
}