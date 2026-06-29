import java.util.Comparator;
import java.util.TreeSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    class Jedi /*implements Comparable<Jedi>*/{
        String nombre;
        int edad;
        String rango;

        Jedi(String nombre, int edad, String rango) {
            this.nombre = nombre;
            this.edad = edad;
            this.rango = rango;
        }

        //Implementamos la comparacion internamente
        // Limitante: solo se comparar así, ya no se puede cambiar
    /*
    @Override
    public int compareTo(Jedi otro) {
        return this.edad - otro.edad;
    }*/
    }
    public static void main(String[] args) {

        TreeSet<Jedi> mi_arbol = new TreeSet<>( (uno, otro) -> uno.edad - otro.edad );
        TreeSet<Jedi> mi_arbol2 = new TreeSet<>( (uno,otro) -> uno.nombre.compareTo(otro.nombre) );


        Comparator<Jedi> mi_comp = (uno, otro) -> uno.edad - otro.edad;
        if(mi_comp.compare(new Jedi("Luke", 21, "Jedi"), new Jedi("Anakin", 19, "Padawan")) < 0) {

        }

        mi_arbol.add(new Jedi("Luke", 21, "Jedi"));

        int[] array = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.MIN_VALUE;
        }

        // Calcular hueco
        int varA = 91;
        int varB = 41;
        int varC = 141;

        // Calcular hueco
        int huecoA = getHuecoVacioLineal(varA, array);
        array[ huecoA ] = varA;
        int huecoB = getHuecoVacioLineal(varB, array);
        array[ huecoB ] = varA;
        int huecoC = getHuecoVacioLineal(varC, array);
        array[ huecoC ] = varA;

        // Calcular hueco
        int var = 91;
        int var2 = 41;
        int var3 = 141;
        int var4 = 191;
        int var5 = 241;
        int var6 = 291;


        // hueco = hashCode % tamaño array


        int hueco = getHuecoVacioCuadratico(var, array);
        array[ hueco ] = var;
        int hueco2 = getHuecoVacioCuadratico(var2, array);
        array[ hueco2 ] = var;
        int hueco3 = getHuecoVacioCuadratico(var3, array);
        array[ hueco3 ] = var;
        int hueco4 = getHuecoVacioCuadratico(var4, array);
        array[ hueco4 ] = var;
        int hueco5 = getHuecoVacioCuadratico(var5, array);
        array[ hueco5 ] = var;
        int hueco6 = getHuecoVacioCuadratico(var6, array);
        array[ hueco6 ] = var;

        System.out.println(hueco);
        System.out.println(hueco2);
        System.out.println(hueco3);
        System.out.println(hueco4);
        System.out.println(hueco5);
        System.out.println(hueco6);
    }

    static int getHuecoVacioLineal(int var, int[] array) {
        int hueco = var % array.length; // hueco en el que debería haber entrado
        int i = 0;

        while (array[(hueco + i) % array.length] != Integer.MIN_VALUE) {
            //hueco += 1; // hueco deja de ser ese sitio original
            i++;
        }

        return (hueco + i) % array.length;
    }

    static int getHuecoVacioCuadratico(int var, int[] array) {
        int hueco = var % array.length; // hueco en el que debería haber entrado
        int i = 0;

        while (array[(hueco + i*i) % array.length] != Integer.MIN_VALUE) {
            //hueco += 1; // hueco deja de ser ese sitio original
            i++;
        }

        return (hueco + i*i) % array.length;
    }

}