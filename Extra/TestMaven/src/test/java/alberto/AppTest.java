package alberto;

import static org.junit.Assert.*;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;


public class AppTest  {

    @Test
    public void comprobarFuncBasico() {
        int result = App.elevar(7, 7);

        assertTrue(result == 1);
    }
}
