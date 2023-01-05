package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;

import java.util.List;

public class ColumnNumberValidator extends AbstractValidator {

    @Override
    public int validate(List<List<Integer>> source) throws SudokuValidationException {
        for (List<Integer> line : source) {
            if (line.size() != 9) {
                throw new SudokuValidationException("There are %s puzzle elements in row. Only 9 columns is acceptable.".formatted(line.size()));
            }
        }
        return super.validate(source);
    }
}
