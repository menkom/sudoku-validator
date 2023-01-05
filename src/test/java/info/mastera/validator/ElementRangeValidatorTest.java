package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

class ElementRangeValidatorTest {

    ElementRangeValidator validator = new ElementRangeValidator();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 9})
    public void test(int value) throws SudokuValidationException {
        Assertions.assertEquals(0, validator.validate(List.of(List.of(value))));
    }

    @Test
    public void testNullValue() throws SudokuValidationException {
        Assertions.assertEquals(0, validator.validate(List.of(Collections.singletonList(null))));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 23})
    public void testValueNotInRange(int value) {
        Assertions.assertThrows(SudokuValidationException.class, () -> validator.validate(List.of(List.of(value))));
    }
}