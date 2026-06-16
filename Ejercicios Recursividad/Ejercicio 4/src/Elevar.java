public class Elevar {
    public static int Potencia(int n, int m){
        if(m == 0){
            return 1;
        }else if(m == 1) {
            return n;
        }else{
            return n * Potencia(n, m -1);
        }
    }
}
