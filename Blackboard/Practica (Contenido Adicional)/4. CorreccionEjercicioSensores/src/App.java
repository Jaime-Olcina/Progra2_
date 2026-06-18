import java.time.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<LecturaSensor> lecturas = new ArrayList<>();
        lecturas.add(new LecturaSensor("#001", 52.2, "Banyo", LocalDateTime.of(2026, 1, 23, 8, 30)));
        lecturas.add(new LecturaSensor("#002", 41.2, "Banyo", LocalDateTime.now()));
        lecturas.add(new LecturaSensor("#003", 51.2, "Salon", LocalDateTime.now()));

        System.out.println(funcion2(lecturas));
    }

    public static ArrayList<LecturaSensor> funcion1(ArrayList<LecturaSensor> lecturas, String tipo ) {
        return new ArrayList<>(lecturas.stream()
                                       .filter((x) -> {
                                            return x.tipo.equals(tipo);
                                     }).collect(Collectors.toList()));
    }

    public static double funcion2(ArrayList<LecturaSensor> lecturas) {
        long numero_medidas_24 = lecturas.stream()
                       .filter((x) -> return Duration.between(x.timestamp, LocalDateTime.now()).getSeconds() <= 86400;})
                       .count();

        lecturas.size();

        return lecturas.stream()
                       .filter((x) -> {
                            return Duration.between(x.timestamp, LocalDateTime.now()).getSeconds() <= 86400; 
                       }).mapToDouble((x) -> {
                            return x.valor;
                       }).reduce(0, (x,y) -> {
                            return x + y / numero_medidas_24;
                       });
    }
}

class LecturaSensor {
    public String id;
    public double valor;
    public String tipo;
    public LocalDateTime timestamp;
    
    LecturaSensor(String id, double valor, String tipo, LocalDateTime timestamp) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Tipo:" + tipo + 
                ", valor:" + valor + 
                ", id:" + id + 
                ", hora:" + timestamp;
    }
};