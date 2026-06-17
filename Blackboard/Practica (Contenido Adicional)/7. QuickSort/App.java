package com.ejercicios;

import java.util.Random;
import java.util.random.*;

public class App 
{
    public static void main( String[] args )
    {
        int[] array = {10,7,8,3,5,2,9,1,4,6};
        quickSort(array);

        for(int elem : array) {
            System.out.print(elem + " ");
        }
         System.out.println();
    }

    public static void quickSort(int[] array) {
        quickSortAux(array, 0, array.length);
    }

    public static void quickSortAux(int[] array, int izq, int dcha) {
        if(dcha - izq <= 1) {
            return;
        }

        //Random r = new Random();
        //int pivote_indice = r.nextInt(izq, dcha);
        int pivote_indice = pivote_indice;
        int pivote = array[pivote_indice];

        int i = izq;
        for (int j = izq; j < dcha; j++) {
            if(array[j] < pivote) {
     
                int aux = array[i];
                array[i] = array[j];
                array[j] = aux;

                if(j == pivote_indice) {
                    pivote_indice = i;
                } else if (i == pivote_indice) {
                    pivote_indice = j;
                }

                i++;
            }

            for(int elem : array) {
            //System.out.print(elem + " ");
            }
            //System.out.println();
        }
        //System.out.println("i es: " + i);
        //System.out.println("pivote_indice es: " + pivote_indice);

        int aux = array[i];
        array[i] = array[pivote_indice];
        array[pivote_indice] = aux;

        quickSortAux(array, izq, pivote_indice);
        quickSortAux(array, pivote_indice, dcha);
    }
}
    