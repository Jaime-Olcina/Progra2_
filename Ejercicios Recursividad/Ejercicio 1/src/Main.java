public class Main {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        int suma = Sumatorio.SumaNatural(n);

        System.out.println("La suma natural desde 1 hasta " + n + " es " + suma);

        int sumaMem = NoMem_Sumatorio.SumaNaturalSinMemoria(0,0); //el acumulador siempre tiene que estar inicializado a 0

        System.out.println("La suma natural desde 1 hasta " + n + " es " + suma);
    }
}