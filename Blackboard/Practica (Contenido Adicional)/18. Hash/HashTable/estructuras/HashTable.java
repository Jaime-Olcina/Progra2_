package estructuras;

public class HashTable implements IHashTable {

    Integer array[] = new Integer[100];

    public HashTable() {
        for(int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
    }

    @Override
    public void add(Integer i) {
        
        int pos = hash(i);
        System.out.println(pos);

        if( array[hash(i)] == -1 ) {
            
            array[hash(i)] = i;
        }
        else if (array[hash(i)].equals(i)) {
            // no hacer nada
        }
        else if (!array[hash(i)].equals(i)) {
            // incremento array
            int tamanyo_nuevo_posible = array.length * 2;
            while (array[hash(i)] != -1) {
                while (!resize(tamanyo_nuevo_posible)) {
                    // aqui dentro solo ocurre si no se ha podido hacer el resize
                    tamanyo_nuevo_posible *= 2;
                }
            }

            array[hash(i)] = i;
        }                
        
    }
    @Override
    public int hash(Integer i) {
        return i.intValue() % array.length;
    }

    @Override
    public boolean resize(int nuevo_tamanyo) {
    // boolean : true si se ha hecho sin colisiones y false si se ha encontrado colision 

        // Crear un array de tamaño nuevo
        Integer nuevo_array[] = new Integer[nuevo_tamanyo];
        for(int i = 0; i < nuevo_array.length; i++) {
            nuevo_array[i] = -1;
        }

         // Meter los numeros antiguos en el nuevo
        for(Integer elem : array) {
            if(elem != -1) {
                if (nuevo_array[elem % nuevo_array.length] == -1) {
                    nuevo_array[elem % nuevo_array.length] = elem;
                }
                else {
                    return false; // cancelar, el nuevo tamanyo es mala idea
                }
            }
            
            
        }

        array = nuevo_array;
        return true;
    }

    @Override
    public boolean find(Integer i) {
        if(array[i] == i) {
            return true; 
        }
        return false;
    }

    @Override
    public String toString() {
        String texto = "{";
        for (Integer elem : array) {
            if(elem != -1) {
                texto += elem + ", ";
            }
        }
        texto += "}";
        return texto;
    }
}
