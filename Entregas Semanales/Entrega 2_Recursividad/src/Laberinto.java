public class Laberinto {
    public static int Contador(int[] i, int j,int marcador, int indice){



        if(i.length==indice){
            return marcador;
        }else{
            if(i[indice]==j){
                return Contador(i,j ,marcador + 1,indice + 1);
            }
            return Contador(i,j ,marcador,indice + 1);
        }


    }
}
