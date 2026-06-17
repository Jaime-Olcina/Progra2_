package estructuras;

public class PilaArray {
    Integer[] array; 
    int primero; // indice

    public PilaArray () {
        array = new Integer[100];
        primero = -1;
    }

    public boolean empty() {
        return primero == -1;
    }

    public Integer pop() {
        if(primero == -1) {
            return null;
        }
        return array[primero--];

        // todo en una linea
        //return primero != -1 ? array[primero--] : null;
    }

    public void push(Integer nuevo_primero) {
        array[++primero] = nuevo_primero;
    }

    public Integer peek() {
        if(primero == -1) {
            return null;
        }
        return array[primero];
    }


    @Override
    public String toString() {
        String elementos = "";
        for (int i = 0; i <= primero; i++) {
            elementos += array[i] + ", ";
        }

        return elementos;
    }
}
