public class Producto implements Comparable<Producto> {
    int id, stock;
    String nombre;

    public Producto(int id, String nombre, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return String.valueOf(id) + " " + nombre + " " + String.valueOf(stock);
    }

    @Override
    public int compareTo(Producto obj) {
        Producto otro = (Producto) obj;
        return this.id - otro.id;
    }
}
