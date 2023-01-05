package info.mastera.validator;

import info.mastera.exception.SudokuValidationException;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public abstract class AbstractValidator implements IValidator {

    private IValidator nextValidator;

    @Override
    public int validate(List<List<Integer>> source) throws SudokuValidationException {
        if (nextValidator != null) {
            return nextValidator.validate(source);
        } else {
            return 0;
        }
    }

    @Override
    public IValidator setNextValidator(IValidator next) {
        this.nextValidator = next;
        return this;
    }

    protected boolean isUnique(Collection<Integer> source) {
        var values = source.stream().filter(Objects::nonNull).toList();
        return values.size() == new HashSet<>(values).size();
    }
}
