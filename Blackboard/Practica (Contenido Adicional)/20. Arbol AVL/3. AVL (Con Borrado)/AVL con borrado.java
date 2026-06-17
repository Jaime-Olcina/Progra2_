

class Main {
    public static void main(String[] args) {
        AVL<Integer> tree = new AVL<>();
        
        tree.insert(3);
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        
        tree.borrar(5);
        tree.borrar(7);
        tree.borrar(6);
        
        tree.inOrder();
    }
}



class AVL<T extends Comparable<T>> {
    
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
    public void borrar(T dato){
        raiz = borrarAux(raiz,dato);
    }
    public Nodo borrarAux(Nodo raiz, T dato){
        if(raiz == null){
            return null;
        }
        if(dato.compareTo(raiz.obj) < 0) {
            raiz.izq = borrarAux(raiz.izq, dato);
        }
        else if (dato.compareTo(raiz.obj) > 0) {
            raiz.dcha = borrarAux(raiz.dcha, dato);
        }
        else {
            if(raiz.izq == null && raiz.dcha == null ) {
                return null; // 0 hijos - mi padre tiene nuevo hijo : null
            }
            else if(raiz.izq != null && raiz.dcha == null){
                return raiz.izq; // 1 hijo izq - mi padre adopta a mi hijol
            }else if(raiz.dcha != null && raiz.izq == null){
                return raiz.dcha; // 1 hijo dcho - mi padre adopta a mi hijol
            }
            else {
                Nodo sig = menor(raiz.dcha);
                raiz.obj = sig.obj;
                raiz.dcha = borrarAux(raiz.dcha, sig.obj);
            }
        }
        
        // ALTURAS - aqui solo llegan nodos no borrados (padres)
        if(raiz.izq == null && raiz.dcha == null) {
            raiz.altura = 1;
        }
        else if(raiz.izq == null) {
            raiz.altura = raiz.dcha.altura + 1;
        }
        else if (raiz.dcha == null) {
            raiz.altura = raiz.izq.altura + 1;
        }
        else {
            raiz.altura = Math.max(raiz.izq.altura, raiz.dcha.altura) + 1;
        }
        
        
        //REBALANCEO
        int dif = balance(raiz); 

        if(dif > 1 && balance(raiz.izq) >= 0) { 
            // DESBALANCEO POR LA IZQ y añado a la izq de mi hijo izq - LL
            // SIMPLE - LL
            System.out.println("Nodo desbal LL: " + raiz);
            raiz = rotacionDcha(raiz);
        }
        else if (dif < -1 && balance(raiz.dcha) <= 0) { 
            // DESBALANCEO POR LA DCHA y añado a la dcha de mi hijo dcho - RR
            // SIMPLE - RR
            System.out.println("Nodo desbal RR: " + raiz);
            raiz = rotacionIzq(raiz);
        }

        else if (dif > 1 && balance(raiz.izq) < 0) { 
            // DESBALANCEO POR LA IZQ y añado a la dcha de mi hijo izq - LR
            // DOBLE - LR
            System.out.println("Nodo desbal LR: " + raiz);
            raiz.izq = rotacionIzq(raiz.izq); // Transformar a LL
            // SIMPLE - LL
            raiz = rotacionDcha(raiz);
        }
        else if (dif < -1 && balance(raiz.dcha) > 0) { 
            // DESBALANCEO POR LA DCHA y añado a la izq de mi hijo dcho - RL
            // DOBLE - RL
            System.out.println("Nodo desbal RL: " + raiz);
            raiz.dcha = rotacionDcha(raiz.dcha); // Transformar a RR
            // SIMPLE - RR
            raiz = rotacionIzq(raiz);
        }
        
        
        return raiz; // si no se borra, decir a mi padre que sigo siendo su hijo
    }
    
    Nodo menor(Nodo raiz) {
        if(raiz == null) return null;
        if(raiz.izq == null){
            return raiz;
        }
        else{
            return menor(raiz.izq);
        }
    }
}

