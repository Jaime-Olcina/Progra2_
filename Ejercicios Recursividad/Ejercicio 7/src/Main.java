//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int indice = 0;
        String palabra = "adbf";

        boolean respuesta = Alfabeto.Ordenada(palabra, indice);

        System.out.println("¿La palabre esta ordenadada? " + respuesta); //Podria hacer un for como en el ejercicio Extra Pares e impares


    }
}