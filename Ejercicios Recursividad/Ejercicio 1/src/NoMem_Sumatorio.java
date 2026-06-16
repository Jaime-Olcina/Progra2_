public class NoMem_Sumatorio {


    public static int SumaNaturalSinMemoria(int n, int acumulador) {

        if (n == 0){
            return acumulador;
        }
        return n + SumaNaturalSinMemoria(n -1, acumulador + n);    //El acumulador es una variable que hace lo que su nombre indica, acumula los valores de el primer numero y el resultado de la siguiente suma
    }
}
