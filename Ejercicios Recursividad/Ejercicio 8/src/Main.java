public class Main {
    public static void main(String[] args) {

        String Word = "reconocer"; //Importante Mayusculas y minusculas
        int Inicio = 0;
        int Final = Word.length()-1;//La palabra es de 9 letras pero los indice van de 0 a 8

        boolean respuesta = Palindromo.Lectura(Word,Inicio,Final);

        System.out.println("¿La palabra " + Word + " es un palindromo?" + respuesta);
    }
}