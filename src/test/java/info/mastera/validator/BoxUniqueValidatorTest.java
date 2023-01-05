package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class BoxUniqueValidatorTest {

    BoxUniqueValidator validator = new BoxUniqueValidator();

    @Test
    public void testCorrect() {
        try {
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
            )));
        } catch (info.mastera.exception.SudokuValidationException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Non unique in square 0:0 in position 1:1 and 2:2 with value 2")
    @Test
    public void testExceptionNonUnique00() {
        Assertions.assertThrows(SudokuValidationException.class, () -> validator.validate(List.of(
                Arrays.asList(9, null, 4, null, 6, null, 7, null, 1),
                Arrays.asList(null, 2, null, 4, null, 3, null, 8, null),
                Arrays.asList(8, null, 2, null, null, null, null, null, 4),
                Arrays.asList(null, null, 1, 8, 4, 9, 6, null, null),
                Arrays.asList(null, null, null, null, null, null, null, null, null),
                Arrays.asList(null, null, 3, 2, 5, 7, 9, null, null),
                Arrays.asList(4, null, null, null, null, null, null, null, 7),
                Arrays.asList(null, 8, null, 6, null, 4, null, 5, null),
                Arrays.asList(5, null, 6, null, 8, null, 2, null, 3)
        )));
    }

    @DisplayName("Non unique in square 0:1 in position 0:4 and 2:5 with value 6")
    @Test
    public void testExceptionNonUnique01() {
        Assertions.assertThrows(SudokuValidationException.class, () -> validator.validate(List.of(
                Arrays.asList(9, null, 4, null, 6, null, 7, null, 1),
                Arrays.asList(null, 2, null, 4, null, 3, null, 8, null),
                Arrays.asList(8, null, null, null, null, 6, null, null, 4),
                Arrays.asList(null, null, 1, 8, 4, 9, 6, null, null),
                Arrays.asList(null, null, null, null, null, null, null, null, null),
                Arrays.asList(null, null, 3, 2, 5, 7, 9, null, null),
                Arrays.asList(4, null, null, null, null, null, null, null, 7),
                Arrays.asList(null, 8, null, 6, null, 4, null, 5, null),
                Arrays.asList(5, null, 6, null, 8, null, 2, null, 3)
        )));
    }

    @DisplayName("Non unique in square 2:1 in position 6:3 and 7:5 with value 4")
    @Test
    public void testExceptionNonUnique21() {
        Assertions.assertThrows(SudokuValidationException.class, () -> validator.validate(List.of(
                Arrays.asList(9, null, 4, null, 6, null, 7, null, 1),
                Arrays.asList(null, 2, null, 4, null, 3, null, 8, null),
                Arrays.asList(8, null, null, null, null, 6, null, null, 4),
                Arrays.asList(null, null, 1, 8, 4, 9, 6, null, null),
                Arrays.asList(null, null, null, null, null, null, null, null, null),
                Arrays.asList(null, null, 3, 2, 5, 7, 9, null, null),
                Arrays.asList(4, null, null, 4, null, null, null, null, 7),
                Arrays.asList(null, 8, null, 6, null, 4, null, 5, null),
                Arrays.asList(5, null, 6, null, 8, null, 2, null, 3)
        )));
    }
}