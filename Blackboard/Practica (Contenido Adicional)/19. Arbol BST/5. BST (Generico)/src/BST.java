

public class BST<T extends Comparable<T>> {
    
    Nodo<T> raiz;

    public BST() {
        raiz = null;
    }

    public void insert(T prod) {
        raiz = insertAux(prod, raiz);
    }

    public Nodo<T> insertAux(T prod_ins, Nodo<T> raiz) {

        if(raiz == null) {
            return new Nodo<T>(prod_ins);
        }

        if(prod_ins.compareTo(raiz.prod) < 0) {
            raiz.izq = insertAux(prod_ins, raiz.izq);
        }
        else if (prod_ins.compareTo(raiz.prod) > 0) {
            raiz.dcha = insertAux(prod_ins, raiz.dcha);
        }
 
        
        return raiz;
    }


    public void inOrder() {
        inOrderAux(raiz);
    }

    public void inOrderAux(Nodo<T> raiz) {
        if(raiz == null) return;

        inOrderAux(raiz.izq);
        System.out.println(raiz);
        inOrderAux(raiz.dcha);
    }
    public int altura() {
        return alturaAux(raiz);
    }

    private int alturaAux(Nodo<T> raiz) {
        if(raiz == null) return 0;

        int alt_izq = alturaAux(raiz.izq);
        int alt_dcha = alturaAux(raiz.dcha);

        return Math.max(alt_izq, alt_dcha) + 1;
    }
}
