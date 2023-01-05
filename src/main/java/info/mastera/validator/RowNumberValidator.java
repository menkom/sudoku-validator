package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;

import java.util.List;

public class RowNumberValidator extends AbstractValidator {

    @Override
    public int validate(List<List<Integer>> source) throws SudokuValidationException {
        if (source.size() != 9) {
            throw new SudokuValidationException("There are %s puzzle rows in source. Only 9 rows is acceptable.".formatted(source.size()));
        }
        return super.validate(source);
    }
}
