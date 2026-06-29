public class Lineal(){
	public static int busquedaLineal(int[] v, int objetivo) {

    	for (int i = 0; i < v.length; i++) {
        	if (v[i] == objetivo) {
        	    return i;
        	}
	    }

	    return -1;
	}
}