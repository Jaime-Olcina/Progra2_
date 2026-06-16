import java.util.stream.IntStream;

public class ElevarStream {
    public static int ElevarPF(int N, int M) {
        return IntStream.iterate(N,x -> x) //Devolverá x,x,x,x,x hasta el limit(m) y aunque es lo mismo que (N, (int x) -> {return x}) podemos prescindir de las llaves debido a que solo hay una instrucción
                .limit(M)
                .reduce(1, (x,y) -> x * y); //Result=Result*NextValue
    }
} //N en el .iterate y el 1 en el .reduce son los valores iniciales
