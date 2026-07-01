package alberto;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AppTest  { //Conjunto de pruebas para la app
    Random r;

    @Before
    public void inicializar(){
        r = new Random();
    }

    @Test
    public void comprobarFuncBasico() {
        int result = App.elevar(7, 2);

        assertTrue(result == 49);
    }

    @Test
    public void comprobarElevarCero() {
        int result = App.elevar(r.nextInt(), 0);

        assertTrue(result == 1);
    }

    @Test
    public void comprobarDividir0(){
        try {
            int result = App.dividir(r.nextInt(), 0);
            fail();
        }
        catch(Exception e) {
            assertNotNull(e);
        }
        }
}
