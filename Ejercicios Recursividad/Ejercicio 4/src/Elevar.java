public class Elevar {
    public static int Potencia(int i, int j){
        if j==0 {
            return 1
        }else if j == 1 {
            return i
        }else{
            return i * Potencia( i,j-1)
        }
        }
    }
}
