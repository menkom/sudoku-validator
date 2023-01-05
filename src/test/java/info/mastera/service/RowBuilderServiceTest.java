package info.mastera.service;

import info.mastera.exception.SudokuValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

class RowBuilderServiceTest {

    RowBuilderService rowBuilderService = new RowBuilderService();

    @Test
    public void test() throws SudokuValidationException {
        Assertions.assertEquals(List.of(), rowBuilderService.split(""));
        Assertions.assertEquals(Arrays.asList(null, null), rowBuilderService.split(","));
        Assertions.assertEquals(Arrays.asList(null, null), rowBuilderService.split(", "));
        Assertions.assertEquals(Arrays.asList(null, null), rowBuilderService.split(" ,"));
        Assertions.assertEquals(Arrays.asList(null, null), rowBuilderService.split(" , "));
        Assertions.assertEquals(List.of(1), rowBuilderService.split("1"));
        Assertions.assertEquals(List.of(23), rowBuilderService.split("23"));
        Assertions.assertEquals(List.of(1, 10), rowBuilderService.split("1, 10"));
        Assertions.assertEquals(Arrays.asList(1, null), rowBuilderService.split("1,"));
        Assertions.assertEquals(Arrays.asList(1, null), rowBuilderService.split("1, "));
        Assertions.assertEquals(Arrays.asList(1, 1), rowBuilderService.split("1,1"));
        Assertions.assertEquals(Arrays.asList(1, 1), rowBuilderService.split("1,1 "));
        Assertions.assertEquals(Arrays.asList(1, 1), rowBuilderService.split(" 1 ,1"));
        Assertions.assertEquals(Arrays.asList(null, null, null), rowBuilderService.split(",,"));
        Assertions.assertEquals(Arrays.asList(null, null, null), rowBuilderService.split(",     ,"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 3", "a", "_"})
    public void testExceptions(String source) {
        Assertions.assertThrows(SudokuValidationException.class, () -> rowBuilderService.split(source));
    }
}