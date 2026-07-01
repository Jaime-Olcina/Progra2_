

import java.util.ArrayList;
import java.util.stream.*;

class A {
    int x;
    String y;
}

public class App {
    public static void main(String[] args) throws Exception {

        IntStream stream = IntStream.range(0, 11).filter(x ->  {
            System.out.println(x);
            return x < 5;
        });

        System.out.println("Before");
        stream.forEach(x -> {
            System.out.println(x);
        });
        System.out.println("After");


        LongStream stream2 = IntStream.range(0, 11).filter(x ->  {
            System.out.println(x);
            return x > 5;
        }).map( x -> x+ 3).mapToLong(x -> (long)x);

        long result = stream2.findFirst().getAsLong(); //Necesario cerrar el stream para ejecutarlo
    }
}
