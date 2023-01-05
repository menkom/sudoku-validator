package info.mastera.service;

import info.mastera.exception.SudokuValidationException;

import java.util.ArrayList;
import java.util.List;

public class PuzzleBuilderService {

    private final RowBuilderService rowBuilderService;

    public PuzzleBuilderService(RowBuilderService rowBuilderService) {
        this.rowBuilderService = rowBuilderService;
    }

    public List<List<Integer>> build(List<String> source) throws SudokuValidationException {
        List<List<Integer>> result = new ArrayList<>();
        for (String line : source) {
            result.add(rowBuilderService.split(line));
        }
        return result;
    }
}
