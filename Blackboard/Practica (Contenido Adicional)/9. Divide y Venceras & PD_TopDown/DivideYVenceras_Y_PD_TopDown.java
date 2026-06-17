import java.time.*;

public class DivideYVenceras_Y_PD_TopDown {
    public static void main(String[] args) throws Exception {

        //LocalDateTime before = LocalDateTime.now();
        //int result = elevar(2, 10000);
        //LocalDateTime after = LocalDateTime.now();

        //System.out.println(result);
        //System.out.println(Duration.between(before,after).getNano());


        LocalDateTime before2 = LocalDateTime.now();
        int result2 = elevarDYVOptimizado(2, 10000);
        LocalDateTime after2 = LocalDateTime.now();

        System.out.println(result2);
        System.out.println(Duration.between(before2, after2));

    }


    public static int elevar(int base, int exponente) {
        if(exponente == 0) {
            return 1;
        }
        return base * elevar(base, exponente - 1);
    }


    public static int elevarDivideYVenceras(int base, int exponente) {
        if(exponente == 0) {
            return 1;
        }
        if(exponente == 1) {
            return base;
        }
        else if(exponente % 2 == 0) {
            int raiz = elevarDivideYVenceras(base, exponente/2);
            return raiz * raiz;
        }
        
        return elevarDivideYVenceras(base, exponente/2) * 
            elevarDivideYVenceras(base, exponente/2 + 1);
    }


    public static int elevarDYVOptimizado(int base, int exponente) {
        return elevarDYVOptimizadoAux(base, exponente, new int[exponente+1]);
    }

    public static int elevarDYVOptimizadoAux(int base, int exponente, int[] chuleta) {
        if(exponente == 0) { return 1;}
        if(exponente == 1) { return base; }
        if(chuleta[exponente] != 0) { return chuleta[exponente]; }
        else if(exponente % 2 == 0) {
            if(chuleta[exponente/2] == 0) {
                int raiz = elevarDYVOptimizadoAux(base, exponente/2, chuleta);
                return raiz * raiz;
            }
            return chuleta[exponente] * chuleta[exponente];
        }
        int raiz_impar;
        int raiz_par;
        if(chuleta[exponente/2] == 0) {
            raiz_impar = elevarDYVOptimizadoAux(base, exponente/2, chuleta); 
        }
        else {
            raiz_impar = chuleta[exponente/2];
        }
        if(chuleta[exponente/2 + 1] == 0) {
            raiz_par = elevarDYVOptimizadoAux(base, exponente/2 + 1, chuleta); 
        }
        else {
            raiz_par = chuleta[exponente/2 + 1];
        }
        return raiz_impar * raiz_par;
    }
}
