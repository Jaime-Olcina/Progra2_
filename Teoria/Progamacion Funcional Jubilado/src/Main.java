
import java.util.stream.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Persona> Conjunto = new ArrayList<>();
                Conjunto.add(new Persona("Paco", "11/12/1939"));
                Conjunto.add(new Persona("Fran", "23/03/1978"));
                Conjunto.add(new Persona("Abelarda", "01/10/2001"));
                Conjunto.add(new Persona("Jose", "30/05/1953"));
                List<String> jubilados = Conjunto
                        .stream()
                        .filter(p -> p.jubilado())
                        .map(p -> p.getNombre())
                        .collect(Collectors.toList());
                jubilados.forEach(System.out::println);
    }
}