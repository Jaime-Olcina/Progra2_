//import java.util.HashSet;
import java.util.*;

class Main {
    public static void main(String[] args) {
        /*HashSet<Integer> hs = new HashSet<>();
        
        hs.add(2);
        hs.add(5);
        hs.add(312);
        
        for(Integer elem : hs) {
            //System.out.println(elem);
        }
        hs.stream().forEach(x -> System.out.println(x));
        
        
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put("ES", 28000);
        map.put("España", 28000);
        map.put("FR", 27000);
        map.values().stream().forEach(x -> System.out.println(x));
        
        
        map.put("FR", 26456400); // Si existe, modifica. Si no, agrega
        map.putIfAbsent("FR", 26456400); // Si existe, nada. Si no, agrega
        map.replace("FR", 26456400);// Si existe, namodifica. Si no, nada
        
        
        HashSet<Integer> set_desde_map = new HashSet<>(  map.values()  );
        
        ArrayList<Integer> al_desde_map = new ArrayList<>(  map.values()  );
   
        System.out.println(map);
        */
    

        /* HashMap<A, Integer> hm = new HashMap<>();
        hm.put(new A(1), 2); 
        hm.put(new A(42), 423); 
        System.out.println(hm); */
        
        
        MiHashMap mhm = new MiHashMap();
        mhm.put("test", 1);
        mhm.put("b", 312);
        System.out.println(mhm); 
        
        System.out.println(mhm.get("b")); 
    }
}

/*class A{
    public A(int a) {
        this.a= a;
    }
    int a;
    
    @Override
    public int hashCode() {
        return 1;
    }
    
    @Override
    public boolean equals(Object o) {
        return true;
    }
}*/

class MiHashMap implements IMiHashMap {
    
    class Pair {
        String key;
        Integer value;
        
        Pair(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
    
    Pair array[] = new Pair[100];
    int max_desplaz = 0;
    
    // ejercicios: putIfAbsent, replace, values() -> devolver un arrayList con los values
    
    @Override 
    public void put(String key, Integer value) {
        int pos = key.hashCode() % array.length;
        
        System.out.println(key.hashCode());
        
        if (array[pos] == null) {
            // vacio
            array[pos] = new Pair(key, value);
        }
        else if(array[pos].key.equals(key)) {
            // Si son identicas las llaves, sustituyo
            array[pos] = new Pair(key, value);
        }
        else {
            // colision mismo hashcode pero diferente string. Colision
            int i = 1;
            int nueva_pos = (pos + i)%array.length;
            while (nueva_pos != pos) {
                if(array[nueva_pos] == null) {
                    array[nueva_pos] = new Pair(key, value);
                    if(i > max_desplaz) {
                        max_desplaz = i;
                    }
                    
                    System.out.println(nueva_pos); 
                    return;
                }
                
                i++;
                nueva_pos = (pos + i)%array.length;
            }
        }
        
    }
    
    @Override
    public Integer get(String key) {
        int pos = key.hashCode() % array.length;
        
        if(array[pos].key.equals(key)) {
            // misma key
            return array[pos].value;
        }
        else {
            for(int despl = 1; despl <= max_desplaz; despl++) {
                
                int nueva_pos = (pos + despl)%array.length;
  
                
                if(array[nueva_pos].key.equals(key)) {

                    return array[nueva_pos].value;
                }
            }
            return null;
        }
        
    }
    
    @Override 
    public int size() {
        return 0;
    }
    
    @Override
    public String toString() {
        String cadena = "{";
        for(int i = 0; i < array.length; i++) {
            if(array[i] != null) {
                cadena += array[i].key + "= " + array[i].value + ", ";
            }
        }
        cadena += "}";
        return cadena;
    }
}

interface IMiHashMap {
    public void put(String key, Integer value);
    public Integer get(String key);
    public int size();
    
}

