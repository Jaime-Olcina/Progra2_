

public class AVL<T extends Comparable<T>> {
    
    class Nodo {
        T obj;
        Nodo izq, dcha;
        int altura;

        Nodo(T obj) {
            this.obj = obj;
            this.izq = this.dcha = null;
            this.altura = 1;
        }

        @Override 
        public String toString() {
            return obj.toString() + " altura: " + altura;
        }
    }

    Nodo raiz;

    public AVL() {
        raiz = null;
    }

    public void insert(T obj) {
        raiz = insertAux(obj, raiz);
    }

    Nodo insertAux(T obj, Nodo raiz) {
        if(raiz == null) {
            return new Nodo(obj);
        }

        if(obj.compareTo(raiz.obj) < 0) {
            raiz.izq = insertAux(obj, raiz.izq);
        }
        else if(obj.compareTo(raiz.obj) > 0) {
            raiz.dcha = insertAux(obj, raiz.dcha);
        }
        else {
            //no puede haber repetidos
            return raiz;
        }

        //recalculo altura
        if(raiz.izq == null) {
            raiz.altura = raiz.dcha.altura + 1;
        }
        else if (raiz.dcha == null) {
            raiz.altura = raiz.izq.altura + 1;
        }
        else {
            raiz.altura = Math.max(raiz.izq.altura, raiz.dcha.altura) + 1;
        }

        // Rebalancear
        int dif = balance(raiz); 

        if(dif > 1 && obj.compareTo(raiz.izq.obj) < 0) { 
            // DESBALANCEO POR LA IZQ y añado a la izq de mi hijo izq - LL
            // SIMPLE - LL
            raiz = rotacionDcha(raiz);
        }
        else if (dif < -1 && obj.compareTo(raiz.dcha.obj) > 0) { 
            // DESBALANCEO POR LA DCHA y añado a la dcha de mi hijo dcho - RR
            // SIMPLE - RR
            raiz = rotacionIzq(raiz);
        }

        else if (dif > 1 && obj.compareTo(raiz.izq.obj) > 0) { 
            // DESBALANCEO POR LA IZQ y añado a la dcha de mi hijo izq - LR
            // DOBLE - LR
            raiz.izq = rotacionIzq(raiz.izq); // Transformar a LL
            // SIMPLE - LL
            raiz = rotacionDcha(raiz);
        }
        else if (dif < -1 && obj.compareTo(raiz.dcha.obj) < 0) { 
            // DESBALANCEO POR LA DCHA y añado a la izq de mi hijo dcho - RL
            // DOBLE - RL
            raiz.dcha = rotacionDcha(raiz.dcha); // Transformar a RR
            // SIMPLE - RR
            raiz = rotacionIzq(raiz);
        }
        
        return raiz;
    }

    int balance(Nodo raiz) {
        int alt_izq = raiz.izq == null ? 0 : raiz.izq.altura;
        int alt_dcha = raiz.dcha == null ? 0 : raiz.dcha.altura;
        return alt_izq - alt_dcha;
    }

    int altura(Nodo raiz) {
        if(raiz == null) return 0; // caso base
        return Math.max(altura(raiz.izq), altura(raiz.dcha)) + 1;  // caso recursivo
    }

    Nodo rotacionDcha(Nodo R) {

        Nodo L = R.izq;
        if(L == null) return R; // seguridad
        Nodo e2 = L.dcha;

        L.dcha = R;
        R.izq = e2;

        // CAMBIO DE ALTURAS
        R.altura = altura(R);
        L.altura = altura(L);

        return L;
    }

    Nodo rotacionIzq(Nodo L) {

        Nodo R = L.dcha;
        if(R == null) return L; // seguridad
        Nodo e2 = R.izq;

        R.izq = L;
        L.dcha = e2;

        // CAMBIO DE ALTURAS
        L.altura = altura(L);
        R.altura = altura(R);

        return R;
    }

    public void inOrder() {
        inOrderAux(raiz);
    }
    void inOrderAux(Nodo raiz) {
        if(raiz == null) return;

        inOrderAux(raiz.izq);
        System.out.println(raiz);
        inOrderAux(raiz.dcha);
    }
}
