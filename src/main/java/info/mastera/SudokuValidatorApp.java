package info.mastera;

import info.mastera.exception.SudokuValidationException;
import info.mastera.service.FileService;
import info.mastera.service.PuzzleBuilderService;
import info.mastera.service.RowBuilderService;
import info.mastera.validator.*;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class SudokuValidatorApp {

    public static void main(String[] args) {
        var filename = args.length == 0 ? "puzzleName.txt" : args[0];
        try {
            var source = new FileService().load(filename);
            var puzzle = new PuzzleBuilderService(new RowBuilderService()).build(source);

            var boxUniqueValidator = new BoxUniqueValidator();
            var columnUniqueValidator = new ColumnUniqueValidator().setNextValidator(boxUniqueValidator);
            var rowUniqueValidator = new RowUniqueValidator()
                    .setNextValidator(columnUniqueValidator);
            var elementRangeValidator = new ElementRangeValidator().setNextValidator(rowUniqueValidator);
            var columnNumberValidator = new ColumnNumberValidator()
                    .setNextValidator(elementRangeValidator);
            var rowNumberValidator = new RowNumberValidator()
                    .setNextValidator(columnNumberValidator);

            System.out.println(rowNumberValidator.validate(puzzle));
        } catch (NoSuchFileException e) {
            System.out.printf("No file %s found.%n", filename);
        } catch (IOException e) {
            System.out.println("File reading error.");
        } catch (SudokuValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}