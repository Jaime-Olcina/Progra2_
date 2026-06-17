public class Main {
    public static void main(String[] args) {

        String Word = "reconocer"; //Importante Mayusculas y minusculas

        boolean respuesta = Palindromo.Lectura(Word);

        System.out.println("¿La palabra " + Word + " es un palindromo? " + respuesta);
    }
}