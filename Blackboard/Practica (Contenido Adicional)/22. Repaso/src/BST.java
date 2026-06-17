public class BST {
    class Nodo {
        Integer value;
        Nodo izq, dcho;

        public Nodo(Integer value) {
            this.value = value;
            izq = dcho = null;
        }

        public void add(Integer value) {
            if(value < this.value) {
                if(izq == null) {
                    izq = new Nodo(value);
                    return;
                }
                izq.add(value);
            }
            else {
                if(dcho == null) {
                    dcho = new Nodo(value);
                    return;
                }
                dcho.add(value);
            }
        }


        public void preorder() {
            System.out.println(this.value);
            if(this.izq != null) this.izq.preorder();
            if(this.dcho != null) this.dcho.preorder();
        }
    }

    Nodo raiz;

    BST() {
        raiz = null;
    }

    public void add(Integer valor) {
        if(raiz == null) raiz = new Nodo(valor);
        else raiz.add(valor);
    }

    public void preorder() {
        if(raiz == null) return;

        System.out.println(raiz.value);
        if(raiz.izq != null)  raiz.izq.preorder();
        if(raiz.dcho != null)  raiz.dcho.preorder();
    }
}
