public class Alfabeto {
    public static boolean Ordenada(String Palabra, int indice){

        if(indice==Palabra.length()-1){
            return true;
        }else{
            if(Palabra.charAt(indice) > Palabra.charAt(indice + 1)){
                return false;
            }
                return Ordenada(Palabra,indice+1);
        }

    }
}
