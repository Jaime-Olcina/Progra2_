

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
            if (raiz.izq.altura >= raiz.dcha.altura) {
                raiz.altura = raiz.izq.altura + 1;
            }
            else {
                raiz.altura = raiz.dcha.altura + 1;
            }
        }

        /* 
        if(raiz.izq.altura - raiz.dcha.altura > 1 || 
            raiz.izq.altura - raiz.dcha.altura < -1 
        ) {
            System.out.println("DESBALANCEADO");
        }*/
        
        return raiz;
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
