public class Sumatorio {
    public static int pares(int[] j){
        return paresAux(0,j,0);
    }

    private static int paresAux(int i, int[] j, int Sumatorio){

        if(i==j.length){
            return Sumatorio;
        }else{

            if(j[i]%2==0){
                return paresAux(i+1,j,Sumatorio+j[i]);
            }
                return paresAux(i+1,j,Sumatorio);
        }
    }
}
