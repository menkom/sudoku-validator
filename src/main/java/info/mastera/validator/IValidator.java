package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;

import java.util.List;

public interface IValidator {

    int validate(List<List<Integer>> source) throws SudokuValidationException;

    IValidator setNextValidator(IValidator next);
}
