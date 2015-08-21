
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by WilliamE on 20/08/2015.
 */
public class PicasYFijasTest {

    PicasYFijas picasYFijas = new PicasYFijas("1234");

    @Test
    public void returnNothing() {
        compareAnswer("5678", 0, 0);
    }

    @Test
    public void returnOnePica() {
        compareAnswer("4567", 1, 0);
        compareAnswer("3890", 1, 0);
    }

    @Test
    public void returnOneFija() {
        compareAnswer("1678", 0, 1);
        compareAnswer("9874", 0, 1);
        compareAnswer("9836", 0, 1);
        compareAnswer("9286", 0, 1);
    }

    @Test
    public void returnTwoPicas() {
        compareAnswer("0125",2,0);
    }
    
    @Test
    public void returnOnePicaAndOneFija() {
        compareAnswer("1359",1,1);
    } 

    @Test
    public void returnTwoFijas() {
        compareAnswer("1256",0,2);
        compareAnswer("1035",0,2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withInvalidNumberThrowException() {
        compareAnswer("12");
    }

    private void compareAnswer(String entry, int... expected) {
        assertArrayEquals(expected, picasYFijas.returnAnswer(entry));
    }
}
