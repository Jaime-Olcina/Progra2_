public class Sumatorio {
    public static int SumaNatural(int n) {

        if (n ==0){ //Ponemos el 0 como número natural debido a que en informatica y computación actua como un sumador neutro, si no simplemente sustituiriamos el 0 por el 1 como el caso base y retornariamos un 1 en vez de un 0
            return 0;
        }
        return n + SumaNatural(n -1);    //Funciona igual que el caso factorial recursivo debido a que el orden de los sumandos no altera el producto
    }
}
