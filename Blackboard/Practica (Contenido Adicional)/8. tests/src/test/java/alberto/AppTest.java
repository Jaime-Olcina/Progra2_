package alberto;

import static org.junit.Assert.*;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;


public class AppTest  {

    @Test
    public void comprobarFuncBasico() {
        int result = App.elevar(7, 2);

        assertTrue(result == 49);
    }

    @Test
    public void comprobarElevarCero() {
        Random r = new Random();  
        int result = App.elevar(r.nextInt(), 0);

        assertTrue(result == 1);
    }
}
