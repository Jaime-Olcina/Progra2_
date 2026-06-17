import java.util.*;

public class Main {
    public static void main(String[] args) {
      String[][] laberinto = {
        {"E", " ", "#", "#", "#"},
        {"#", " ", " ", " ", "S"},
        {"#", "#", " ", "#", "#"},
        {"#", " ", " ", " ", "#"},
        {"#", "#", "#", "#", "#"},
      };
      
      //System.out.println(laberinto[0][0]);
      
      //System.out.println(laberinto[1][0]);
      //System.out.println(laberinto[2][0]);
      
      //System.out.println(laberinto[0][1]);
      //System.out.println(laberinto[0][2]);
      
      backtracking(laberinto, 0, 0, new ArrayList<>());
    }
    
    
    public static Boolean isSolved(String[][] laberinto, int x, int y) {
      if(y < 0 || x < 0 || 
        y >= laberinto.length || x >= laberinto[0].length) {
        return false;
      }
      
      else if (laberinto[y][x] == "S") {
        return true;
      }
      return false;
    }
    
    public static void mostrarSolucion(ArrayList<String> solucion) {
      System.out.println("SOLUCION :" + solucion);
    }
    
    public static void backtracking(String[][] laberinto, int x, int y, ArrayList<String> solucion) {
      // Condicion de salida : es la salida
      if(isSolved(laberinto, x, y)) {
        mostrarSolucion(solucion);
        return;
      }
      
      // Revisar opciones
      String[] opciones = {"U", "D", "L", "R"};
      
      for (String nueva_opcion : opciones) {
        // Comprobar nueva solucion
        
        int nueva_x = x;
        int nueva_y = y;
        switch(nueva_opcion) {
          case "U":
            nueva_y--;
            break;
          case "D":
            nueva_y++;
            break;
          case "L":
            nueva_x--;
            break;
          case "R":
            nueva_x++;
            break;
          default:
            break;
        }
        
        
        
        // Es valida?
        if(opcionValida(laberinto, nueva_x, nueva_y, solucion, nueva_opcion)) {
          System.out.println("Posible? :" + solucion);
          
          // Anyadir opcion a solucion
          solucion.add(nueva_opcion);
        
          // Probar
          backtracking(laberinto, nueva_x, nueva_y, solucion);
          
          // Probar otra cosa
        solucion.remove(solucion.size() - 1);
        }
        
        
      }
    }
    
    public static Boolean opcionValida(String[][] laberinto, int x, int y, ArrayList<String> solucion, String nueva_opcion) {
      // REGLAS
      
      // No se puede salir fuera del mapa
      if(y < 0 || x < 0 || 
        y >= laberinto.length || x >= laberinto[0].length) {
        return false;
      }

      // No se puede estar en una pared
      if(laberinto[y][x] == "#") {
        return false;
      }

      // Primer movimiento (no pared o fuera del mapa) - VALIDO
      // Se hace ahora porque luego viene solucion.get(solucion.size() - 1)
      if(solucion.size() == 0) {
        return true;
      }

      // No se puede retroceder
      if(solucion.get(solucion.size() - 1) == "D" && nueva_opcion == "U") {
        return false;
      }
      else if(solucion.get(solucion.size() - 1) == "U" && nueva_opcion == "D") {
        return false;
      }
      else if(solucion.get(solucion.size() - 1) == "L" && nueva_opcion == "R") {
        return false;
      }
      else if(solucion.get(solucion.size() - 1) == "R" && nueva_opcion == "L") {
        return false;
      }
      
      // Movimiento VALIDO
      return true;
    }
}
