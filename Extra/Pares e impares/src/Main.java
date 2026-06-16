public class Main {
    public static void main(String[] args) {

        int i = 10;

        int respuesta = Divisor.Dos(i);

        if(respuesta == 0) {
            System.out.println("El número " + i + " es par ya que el resto da " + respuesta);
        }else if(respuesta==1) {
            System.out.println("El número " + i + " es impar ya que el resto da " + respuesta);
        }
    }
}