public class Palindromo {
    public static boolean Lectura(String Palabra, int indice1, int indice2){

       if(Palabra.length()%2==0){
            if(Palabra.charAt(indice1)!=Palabra.charAt(indice2)){
                return false;
            }
                if(indice1+1==indice2){
                    return true;
                }
                return Lectura(Palabra,indice1+1,indice2-1);
        }
            if(Palabra.charAt(indice1)!=Palabra.charAt(indice2)){
                return false;
        }
            if(indice1==indice2){
                return true;
        }
            return Lectura(Palabra,indice1+1,indice2-1);
    }
}
