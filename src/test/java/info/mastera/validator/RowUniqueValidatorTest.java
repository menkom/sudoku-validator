package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class RowUniqueValidatorTest {

    RowUniqueValidator validator = new RowUniqueValidator();

    @Test
    public void test() throws SudokuValidationException {
        Assertions.assertEquals(0, validator.validate(List.of(
                        Arrays.asList(1, 2),
                        Arrays.asList(null, null),
                        List.of()
                ))
        );
    }

    @Test
    public void testException() {
        Assertions.assertThrows(SudokuValidationException.class, () -> validator.validate(List.of(List.of(1, 1))));
    }
}