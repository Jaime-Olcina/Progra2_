


public class App {

    public static void main(String[] args) throws Exception {

        // RECURSIVIDAD CON MEMORIA
        //a(0);

        // VERSION BUCLE EQUIVALENTE
        //for(int x=0; x<10; x++) {
        //    System.out.println(x);
        //}


        int array[] = {1,2,3,4,5};
        //System.out.println(sumarArray(array, 0, 0));
        System.out.println(media(array, 0, 0));

        //System.out.println(factorial(3));
    }

    // ALGORTIMO RECURSIVO CON MEMORIA (EQ. A BUCLE)
    public static int sumarArray(int[] array, int i, int suma) {
        if (i < array.length) {
            suma = sumarArray(array, i+1, suma + array[i]);
        }
        return suma;
    }

    public static double media(int[] array, int i, double media) {
        System.out.println(media);
        if (i < array.length) {
            media = media(array, i+1, media + (double)array[i]/array.length);
        }
        return media;
    }


    public static int factorial(int x) {
        if(x == 1) {
            return 1;
        }
        return x * factorial(x-1);
    }


    //public static void a(int x) {
    //    System.out.println(x);
    //    if(x < 10) {
    //        a(x+1);
    //    }  
    //}


}
