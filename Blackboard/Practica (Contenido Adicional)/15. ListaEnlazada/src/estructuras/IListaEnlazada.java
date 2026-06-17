package estructuras;

public interface IListaEnlazada {
    // Acceso
    public int acceder(int indice);
    
    // Borrado
    public boolean borrar(int indice);

    // Anyadir
    public boolean anyadir(int elemento); // al final
    public boolean anyadir(int elemento, int lugar); // donde diga lugar

    // Buscar
    public int buscar(int elemento);

    // Tamanyo
    public int tamanyo();
} 