import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    
    public static void main(String[] args) {
        //cambioDeMonedas(6.71);
    }

    public static void resolverSudoku(int[][] sudoku) {
        // falta funcion - hay solucion?  
        resolverSudokuAux(sudoku, 0,0);
    }

    public static boolean resolverSudokuAux(int[][] sudoku, int fila, int col) {
        if (fila == 8 && col == 9) {
            return true;
        }
        
        // Exploracion (me salgo por la derecha)
        if (col == 9) {
            col = 0;
            fila++;
        }

        // Si ya hay un numero en esa casilla
        if (sudoku[fila][col] != 0) {
            resolverSudokuAux(sudoku, fila, col + 1);
        }


        // BACKTRACKING
        // - Comprobar si las opciones son validas
        // - Probar las validas
        // - Si ocurre un camino sin salida, volver para atras (en recursividad, es hacer return) 
        for(int opcion = 1; opcion <= 9; opcion++) {
            if(casillaCorrecta(sudoku, fila, col, opcion)) {
                sudoku[fila][col] = opcion;
                if(resolverSudokuAux(sudoku, fila, col + 1)) {
                    return true;
                }
                sudoku[fila][col] = 0;
            }
        }

        return false;
    }

    public static boolean casillaCorrecta(int[][] sudoku, int fila, int col, int num) {
        // En la columna hay un num
        for(int i = 0; i < 9; i++) {
            if (sudoku[i][col] == num) {
                return false; // Si, por tanto, no es valido
            } 
        }

        // En la fila hay un num
        for(int i = 0; i < 9; i++) {
            if (sudoku[fila][i] == num) {
                return false; // Si, por tanto, no es valido
            } 
        }

        // En el cuadrado de 3x3 hay un num
        int fila_cuadrado = fila - fila % 3;
        int col_cuadrado = fila - fila % 3;
        for(int i = fila_cuadrado; i < fila_cuadrado + 3; i++) {
             for(int j = col_cuadrado; j < col_cuadrado + 3; j++) {
                if (sudoku[i][j] == num) {
                    return false; // Si, por tanto, no es valido
                } 
            }
        }

        return true;
    }










    public static List<Double> cambioDeMonedas(double cantidad) {
        double[] opciones = {2.00, 1.00, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
        int mejor_opcion = 0;
        double e = 0.001; // margen de error por culpa de la coma de los double
        
        ArrayList<Double> solucion = new ArrayList<>();

        while (cantidad > 0) {
            if(mejor_opcion >= 8) break; // seguridad

            if((cantidad + e) < opciones[mejor_opcion]) {
                // Opcion no valida. Descartar
                mejor_opcion++;
            } else {
                // Elegir esa opcion
                solucion.add( opciones[mejor_opcion]);
                System.out.println( opciones[mejor_opcion]);
                cantidad -= opciones[mejor_opcion]; 
            }
        }

        return solucion;
    }



}
