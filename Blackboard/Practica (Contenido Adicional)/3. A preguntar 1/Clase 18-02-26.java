// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.function.*;
import java.util.stream.*;
import java.util.ArrayList;

@FunctionalInterface
interface FI<T> {
    public void f(T x);
}
//interface FI<T, R> {
//    public R f(T x);
//}

class Main {
    
    public static void funcion(FI<Integer> fi, int x) {
        fi.f(x);
    }
    
    public static void f2(Consumer c, String x) {
        c.accept(x);
    }
    
    public static void main(String[] args) {
        //FI fi = (x) -> {};
        //funcion( (x) -> {System.out.println(x);}, 4 );
        
        //funcion( (x) -> {System.out.println(x);}, 4 );
        
        //FI fi2 = (x) -> {System.out.println("tu num:" + x);};
        
        // Para la FI con T y R
        //FI fi3 = (x) -> {return "a";};
        //fi3.f(2);
        
        f2( (x) -> {System.out.println(x);}, "trabajo" );
        
        System.out.println(elevar(3 , 4));
        
        fibonacci(9);
    }
    
    
    
    // EJ 4
    public static int elevar(int N, int M) {
        return IntStream.iterate(N, (x) -> {return x;})
                        .limit(M)
                        .reduce(1, (x,y) -> x * y);
    }
    
    // EJ 5
    public static int fibonacci(int N) {
        ArrayList<Integer> memoria = new ArrayList<>();
        memoria.add(0); // pos-2

        // x es 1 anterior (pos-1)
        IntStream.iterate(1, (x) -> {
            int num = x + memoria.get(memoria.size()-1);
            memoria.add(x);
            return num;
        }).limit(N).forEach((x) -> System.out.println(x));
        
        return 1;
    }
}