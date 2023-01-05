package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RowNumberValidatorTest {

    RowNumberValidator validator = new RowNumberValidator();

    @Test
    public void test() throws SudokuValidationException {
        Assertions.assertEquals(0, validator.validate(List.of(
                List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of())));
    }

    @Test
    public void testException() {
        Assertions.assertThrows(SudokuValidationException.class, () -> validator.validate(List.of(List.of())));
        Assertions.assertThrows(SudokuValidationException.class, () -> validator.validate(List.of(
                List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of())));
        Assertions.assertThrows(SudokuValidationException.class, () -> validator.validate(List.of(
                List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of())));
    }
}