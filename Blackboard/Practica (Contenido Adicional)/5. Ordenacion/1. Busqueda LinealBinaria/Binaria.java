public class Binaria(){
	public static int busquedaBinaria(int[] v, int objetivo) {

    	int izquierda = 0;
    	int derecha = v.length - 1;

    	while (izquierda <= derecha) {

        	int medio = (izquierda + derecha) / 2;

        	if (v[medio] == objetivo) {
            		return medio;
        	}

        	if (v[medio] < objetivo) {
            		izquierda = medio + 1;
        	} else {
            		derecha = medio - 1;
        	}
    	}

    return -1;
    }
}