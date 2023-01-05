package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;

import java.util.List;

public class ElementRangeValidator extends AbstractValidator {

    @Override
    public int validate(List<List<Integer>> source) throws SudokuValidationException {
        for (List<Integer> line : source) {
            for (Integer element : line) {
                if (element != null && (1 > element || element > 9)) {
                    throw new SudokuValidationException("Wrong number `%s`. Only numbers from 1 to 9 are accepted.".formatted(element));
                }
            }
        }
        return super.validate(source);
    }
}
