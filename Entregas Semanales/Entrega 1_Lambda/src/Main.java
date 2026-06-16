import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ArrayList<LecturaSensor> lecturas = new ArrayList<>();

        lecturas.add(new LecturaSensor(
                "#001",
                52.2,
                "Banyo",
                LocalDateTime.of(2026, 1, 23, 8, 30)));

        lecturas.add(new LecturaSensor(
                "#002",
                41.2,
                "Banyo",
                LocalDateTime.now()));

        lecturas.add(new LecturaSensor(
                "#003",
                51.2,
                "Salon",
                LocalDateTime.now()));

        // PREGUNTA 1
        System.out.println("=== FILTRAR POR TIPO ===");
        ArrayList<LecturaSensor> filtradas = funcion1(lecturas, "Banyo");
        filtradas.forEach(System.out::println);

        // PREGUNTA 2
        System.out.println("\n=== PROMEDIO ÚLTIMAS 24 HORAS ===");
        System.out.println(funcion2(lecturas));

        // PREGUNTA 3
        System.out.println("\n=== LECTURA CON VALOR MÁXIMO ===");
        System.out.println(funcion3(lecturas));
    }

    // PREGUNTA 1
    public static ArrayList<LecturaSensor> funcion1(ArrayList<LecturaSensor> lecturas, String tipo) {

        return new ArrayList<>(
                lecturas.stream()
                        .filter(x -> x.tipo.equals(tipo))
                        .collect(Collectors.toList())
        );
    }

    // PREGUNTA 2
    public static double funcion2(ArrayList<LecturaSensor> lecturas) {

        return lecturas.stream()
                .filter(x ->
                        Duration.between(x.timestamp, LocalDateTime.now())
                                .getSeconds() <= 86400)
                .mapToDouble(x -> x.valor)
                .average()
                .orElse(0);
    }

    // PREGUNTA 3
    public static LecturaSensor funcion3(ArrayList<LecturaSensor> lecturas) {

        return lecturas.stream()
                .max((x, y) -> Double.compare(x.valor, y.valor))
                .orElse(null);
    }
}