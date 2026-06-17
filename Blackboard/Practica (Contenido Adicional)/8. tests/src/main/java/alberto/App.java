package alberto;

public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    }

    public static int elevar(int x, int n) {
        int resultado = 1;
        for(int i = 0; i < n; i++) {
            resultado *= x;
        }
        return resultado;
    }
}
