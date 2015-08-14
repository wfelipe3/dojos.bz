import org.junit.Test;

import java.util.NoSuchElementException;

import static com.bizagi.dojobz.option.Option.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by WilliamE on 13/08/2015.
 */
//some(T t)
//none()
//someOfNullable(T t)
public class OptionTest {

    @Test
    public void givenOptionWithValueFive_WhenGetIsCalled_ThenReturnFive() throws Exception {
        assertEquals(Integer.valueOf(5), some(5).get());
    }

    @Test
    public void givenOptionWithValueSix_WhenGetIsCalled_ThenReturnSix() throws Exception {
        assertEquals(Integer.valueOf(6), some(6).get());
    }

    @Test
    public void givenOptionWithValueEmptyString_WhenGetIsCalled_ThenReturnEmptyString(){
        assertEquals("", some("").get());
    }

    @Test(expected = NoSuchElementException.class)
    public void givenOptionWithNullValue_WhenGetIsCalled_ThenThrowException() throws Exception {
        some(null).get();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenInvokeNomeMethod_ThenThrowException() {
        none().get();
    }
    
    @Test
    public void givenOptionWithValue_whenSomeNullableCalled_thenReturnValueInGet() {
        assertEquals("abc", someNullable("abc").get());
    }

    @Test(expected = NoSuchElementException.class)
    public void givenOptionWithNone_whenSomeNullableCalled_thenThrowException() {
        someNullable(null).get();
    }

    @Test
    public void givenOptionWithValue_WhenGetOrElseIsCalled_ThenReturnValue() {
        assertEquals(Integer.valueOf(10), some(10).orElse(20));
        assertEquals(Integer.valueOf(50), some(50).orElse(20));
    }

    @Test
    public void givenOptionNone_WhenGetOrElseIsCalled_ThenReturnElse() {
        assertEquals(10, none().orElse(10));
        assertEquals("OrElse", none().orElse("OrElse"));
    }

    @Test
    public void givenSomeNullableOption_WhenGetOrElseIsCalled_ThenReturnElse() {
        assertEquals(20, someNullable(null).orElse(20));
        assertEquals(Integer.valueOf(1), someNullable(1).orElse(20));

    }

    @Test
    public void map() {
      assertEquals(Integer.valueOf(3), some("abc").map(x->x.length()).get());
    }
}
