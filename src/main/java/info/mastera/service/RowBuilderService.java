package info.mastera.service;

import info.mastera.exception.SudokuValidationException;

import java.util.ArrayList;
import java.util.List;

public class RowBuilderService {

    public List<Integer> split(String row) throws SudokuValidationException {
        var result = new ArrayList<Integer>();
        int startIndex = 0;
        for (int i = 0; i < row.length(); i++) {
            var symbol = row.charAt(i);
            if (symbol == ',') {
                result.add(convert(row.substring(startIndex, i)));
                if (i == row.length() - 1) {
                    result.add(null);
                }
                startIndex = i + 1;
            } else if (i == row.length() - 1) {
                result.add(convert(row.substring(startIndex, i + 1)));
                startIndex = i + 1;
            }
        }
        return result;
    }

    private Integer convert(String element) throws SudokuValidationException {
        if (element.isBlank()) {
            return null;
        } else {
            try {
               return Integer.parseInt(element.strip());
            } catch (NumberFormatException ex) {
                throw new SudokuValidationException("Wrong value `%s`. Numbers from 1 to 9 separated with commas are accepted".formatted(element));
            }
        }
    }
}
