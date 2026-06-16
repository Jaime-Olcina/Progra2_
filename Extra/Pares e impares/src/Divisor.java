public class Divisor {
    public static int Dos(int n) {

    if(n==0 || n==2){
        return 0;
    }else if(n%2!=0){
        return 1;
        }
        return Dos(n-2); //Podria poner perfectamente un return 0 en vez de llamar a la funcion ya que todo numero que sea divisible entre 2 es par, pero dejaria de ser recursivo
    }
}
