package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;

import java.util.LinkedList;
import java.util.List;

public class BoxUniqueValidator extends AbstractValidator {

    @Override
    public int validate(List<List<Integer>> source) throws SudokuValidationException {
        List<Integer> box = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                box.add(source.get((j / 3) + (i / 3) * 3).get((j % 3) + (i % 3) * 3));
            }
            if (!isUnique(box)) {
                throw new SudokuValidationException("Box 3x3 in puzzle is not valid");
            }
            box.clear();
        }
        return super.validate(source);
    }
}
