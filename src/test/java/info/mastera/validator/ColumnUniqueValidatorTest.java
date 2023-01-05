package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ColumnUniqueValidatorTest {

    ColumnUniqueValidator validator = new ColumnUniqueValidator();

    @Test
    public void test() throws SudokuValidationException {
        Assertions.assertEquals(0, validator.validate(List.of(
                        Arrays.asList(9, null, 4, null, 6, null, 7, null, 1),
                        Arrays.asList(null, 2, null, 4, null, 3, null, 8, null),
                        Arrays.asList(8, null, null, null, null, null, null, null, 4),
                        Arrays.asList(null, null, 1, 8, 4, 9, 6, null, null),
                        Arrays.asList(null, null, null, null, null, null, null, null, null),
                        Arrays.asList(null, null, 3, 2, 5, 7, 9, null, null),
                        Arrays.asList(4, null, null, null, null, null, null, null, 7),
                        Arrays.asList(null, 8, null, 6, null, 4, null, 5, null),
                        Arrays.asList(5, null, 6, null, 8, null, 2, null, 3)
                ))
        );
    }

    @Test
    public void testException() {
        Assertions.assertThrows(SudokuValidationException.class, () -> validator.validate(List.of(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9),
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9),
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9),
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9),
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9),
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9),
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9),
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9),
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
        )));
    }
}