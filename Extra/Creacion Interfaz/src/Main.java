import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;




public class Main {
    public static void main(String[] args) {
        //Namer impresion = new Concatenar();

        // Namer concatenar = n -> "[" + n + "]"; //La interfaz usada por lambda directamente en vez de por una clase distinta
        Namer impresion = (x) -> "[" + x + "]";
       // impresion.convertir(2);

       // Predicate<Integer> pred = (c) -> c > 5;
        //pred.test(1);



        String resultado = IntStream.rangeClosed(40, 60)
                .mapToObj(impresion::convertir)
                .collect(Collectors.joining(",")); //.joining concatena en el orden recibido

        System.out.println(resultado);


    }

}
