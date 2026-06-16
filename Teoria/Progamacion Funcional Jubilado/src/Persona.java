import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Persona {

    public String Nombre;
    public Date Nacimiento;

    public Persona(String nombre, String nacimiento) {
        this.Nombre = nombre;
        try{
            Nacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(nacimiento);
        } catch (Exception ex) {
            System.out.println("Error:"+ex);
        }
    }
    public String getNombre() {
        return Nombre;
    }
    public String getNacimiento() {
        return Nacimiento.toString();
    }


    @Override
    public String toString() {
        return ", Nombre: " + Nombre +
                ", Fecha: " + Nacimiento;
    }

    public boolean jubilado() {

        Calendar hoy = Calendar.getInstance();

        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.setTime(Nacimiento);

        int edad =
                hoy.get(Calendar.YEAR)
                        - fechaNacimiento.get(Calendar.YEAR);

        return edad >= 65;
    }

}
