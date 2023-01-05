package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

class AbstractValidatorTest {

    AbstractValidator validator = new AbstractValidator() {
    };
    IValidator nextValidator;

    @BeforeEach
    public void init() {
        nextValidator = Mockito.mock(IValidator.class);
    }

    @Nested
    public class ValidateTest {

        @Test
        public void testWithoutNextValidator() throws SudokuValidationException {
            Assertions.assertEquals(0, validator.validate(List.of(List.of())));
        }

        @Test
        public void testWithNextValidator() throws SudokuValidationException {
            validator.setNextValidator(nextValidator);

            Assertions.assertEquals(0, validator.validate(List.of(List.of())));
            Mockito.verify(nextValidator).validate(ArgumentMatchers.any());
        }
    }

    @Nested
    public class IsUniqueTest {

        @Test
        public void testTrue() {
            Assertions.assertTrue(validator.isUnique(List.of()));
            Assertions.assertTrue(validator.isUnique(List.of(1)));
            Assertions.assertTrue(validator.isUnique(List.of(1, 2)));
            Assertions.assertTrue(validator.isUnique(Arrays.asList(null, 2)));
            Assertions.assertTrue(validator.isUnique(Arrays.asList(1, null)));
            Assertions.assertTrue(validator.isUnique(Arrays.asList(null, null)));
            Assertions.assertTrue(validator.isUnique(Arrays.asList(1, 2, 3)));
        }

        @Test
        public void testFalse() {
            Assertions.assertFalse(validator.isUnique(Arrays.asList(1, 1)));
            Assertions.assertFalse(validator.isUnique(Arrays.asList(1, 1, 1)));
            Assertions.assertFalse(validator.isUnique(Arrays.asList(1, null, 1)));
        }
    }
}