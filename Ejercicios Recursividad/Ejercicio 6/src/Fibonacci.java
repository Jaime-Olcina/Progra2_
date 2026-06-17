public class Fibonacci {
    public static int Calculo(int n, int m, int iter){

        if(iter==0){
            return n;
        }else if(iter==1){
            return m;
        }
            return Calculo(m,n+m, iter-1);
    }
}
