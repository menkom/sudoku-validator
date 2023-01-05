package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;

import java.util.List;

public class RowUniqueValidator extends AbstractValidator {

    @Override
    public int validate(List<List<Integer>> source) throws SudokuValidationException {
        for (List<Integer> line : source) {
            if (!isUnique(line)) {
                throw new SudokuValidationException("Row in puzzle is not valid");
            }
        }
        return super.validate(source);
    }
}
