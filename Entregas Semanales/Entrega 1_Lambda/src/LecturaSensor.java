import java.time.LocalDateTime;

public class LecturaSensor {

    public String id;
    public double valor;
    public String tipo;
    public LocalDateTime timestamp;

    public LecturaSensor(String id, double valor, String tipo, LocalDateTime timestamp) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo +
                ", valor: " + valor +
                ", id: " + id +
                ", hora: " + timestamp;
    }
}
