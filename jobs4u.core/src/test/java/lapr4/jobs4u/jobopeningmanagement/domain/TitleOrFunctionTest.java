package lapr4.jobs4u.jobopeningmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

/**
 * @author 2DI2
 */
public class TitleOrFunctionTest {

    @Test
    public void testTitleOrFunctionCreation() {
        String titleOrFunction = "TitleOrFunction";
        TitleOrFunction contractType = TitleOrFunction.valueOf(titleOrFunction);
        assertEquals(contractType.toString(), titleOrFunction);
    }

    @Test
    public void testTitleOrFunctionCreationBig() {
        String titleOrFunction = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac magna sit amet purus gravida tristique. Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.";
        assertThrows(IllegalArgumentException.class, () -> {
            TitleOrFunction.valueOf(titleOrFunction);
        });
    }

    @Test
    public void testTitleOrFunctionCreationWithInvalidEmptyValue() {
        String titleOrFunction = "";
        assertThrows(IllegalArgumentException.class, () -> {
            TitleOrFunction.valueOf(titleOrFunction);
        });
    }

    @Test
    public void testTitleOrFunctionCreationWithNullValue() {
        String titleOrFunction = null;
        assertThrows(IllegalArgumentException.class, () -> {
            TitleOrFunction.valueOf(titleOrFunction);
        });
    }
}