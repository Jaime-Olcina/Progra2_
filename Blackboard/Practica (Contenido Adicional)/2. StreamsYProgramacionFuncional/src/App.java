

import java.util.ArrayList;
import java.util.stream.*;

class A {
    int x;
    String y;
}

public class App {
    public static void main(String[] args) throws Exception {
        // Recordatorio
        // Crear un stream a partir de un ArrayList
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<A> al2 = new ArrayList<>(); 

        al.add(1);
        al.add(2);

        Stream<Integer> stream1 = al.stream(); // Stream<Integer>
        Stream<A> stream2 = al2.stream();
        stream2.map(a -> {
            a.x++;
            a.y.charAt(0);
            return a;
        });
 
        // Metodo 2 - of - Incluye lo que esta entre parentesis
        IntStream.of(1,2,3);
        DoubleStream.of(2.3, 1.2);
        

        // Metodo 3 - range - Desde el primer parametro, hasta el segundo-1
        IntStream.range(1,7);
        //DoubleStream.range();


        // Metodo 4 - iterate/limit - Genera numeros a partir de una funcion anonima
        IntStream.iterate(0, (x) -> {
            x += 1; 
            return x;
        }).limit(5);




        // Nuevo:
        // funcion forEach() - Su requerimiento es un funcion anonima que devuelva VOID - Acaba el Stream
        IntStream.range(1,11).forEach(x -> {
            System.out.println(x);
        });


        // funcion map() - Su requerimiento es una funciona anonima que devuelva ? - No acaba el Stream
        // ? es el tipo del Stream - El tipo que asumimos para x
        // Modificar los elementos
        IntStream.range(1,11).map(x -> x+1).forEach(x -> {
            System.out.println(x);
        });



        // funcion filter() - Su requerimiento es un funcion anonima que devuelva boolean - No acaba el Stream
        // Si el booleano es true, el elemento sigue
        // Si el booleano es false, el elemento muere

        IntStream.range(1,11).filter(x -> {
            return x < 5;
        }).forEach(x -> {
            System.out.println(x);
        });




        // funcion reduce() - Su requerimiento es un funcion con 2 parametros, y que devuelva ? - Acaba el Stream
        // ? es el tipo del Stream - El tipo que asumimos para x e y
        // Agrupar todos los elementos mediante alguna formula o similar y que solo quede 1
        // Intstream -> al hacer reduce -> Integer

        System.out.println(  
            IntStream.range(1,11).reduce(5, (x,y) -> {
                return x + y;
            }) 
        );



        // Documentacion de otras funciones...
        // https://docs.oracle.com/javase/8/docs/api/?java/util/stream/Stream.html

        IntStream.of(1,1,1,1,11).distinct().forEach(x -> {
            System.out.println(x);
        });


        // Hacemos la media del ArrayList:

    }
}
