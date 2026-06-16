public class Numero {
    public static int Digitos(int i){
        if(i<10){
            return 1;
        }
        return 1 + Digitos(i/10);
    }
}
