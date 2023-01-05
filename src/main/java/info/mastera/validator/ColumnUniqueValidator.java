package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;

import java.util.LinkedList;
import java.util.List;

public class ColumnUniqueValidator extends AbstractValidator {

    @Override
    public int validate(List<List<Integer>> source) throws SudokuValidationException {
        List<Integer> column = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                column.add(source.get(j).get(i));
            }
            if (!isUnique(column)) {
                throw new SudokuValidationException("Column in puzzle is not valid");
            }
            column.clear();
        }
        return super.validate(source);
    }
}
