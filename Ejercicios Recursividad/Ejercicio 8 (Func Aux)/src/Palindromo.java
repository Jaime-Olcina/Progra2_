public class Palindromo {
    public static boolean Lectura(String Palabra) {

        return PalindromoAux.LecturaAux(Palabra, 0, Palabra.length() - 1);
    }
}