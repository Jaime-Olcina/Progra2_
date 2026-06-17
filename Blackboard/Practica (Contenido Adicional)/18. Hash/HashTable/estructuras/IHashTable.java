package estructuras;

public interface IHashTable {
    public void add(Integer i);

    public boolean find(Integer i);

    public int hash(Integer i);

    public boolean resize(int i);
}
