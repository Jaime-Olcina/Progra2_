import java.lang.reflect.Array;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] i = {1, 9, 1, 9};
        int numero = 0;

        for (int k = 0; k < i.length; k++) {
            int cifra = i[k];
            numero = numero * 10 + cifra;
        }

        int j = 9;

        int n = Laberinto.Contador(i,j,0,0);

                System.out.println("Encontramos el número " + j + " en el número " + numero + " " + n + " veces" );
    }
}