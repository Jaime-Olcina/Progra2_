import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] numeros = {8, 3, 12, 5, 20, 9};

        int mayor = MayorElemento.buscarMayor(numeros);

        System.out.println("Mayor: " + mayor);

        int factorial = Factorial.calcular(5);

        System.out.println("Factorial: " + factorial);
    }
}