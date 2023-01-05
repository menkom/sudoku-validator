package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ColumnNumberValidatorTest {

    ColumnNumberValidator validator = new ColumnNumberValidator();

    @Test
    public void test() throws SudokuValidationException {
        Assertions.assertEquals(0, validator.validate(List.of(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9))));
    }

    @Test
    public void testException() {
        Assertions.assertThrows(SudokuValidationException.class, () -> validator.validate(List.of(List.of(1, 2, 3, 4, 5, 6, 7, 8))));
        Assertions.assertThrows(SudokuValidationException.class, () -> validator.validate(List.of(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))));
    }
}