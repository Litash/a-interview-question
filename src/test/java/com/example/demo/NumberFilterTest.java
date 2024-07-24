package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberFilterTest {
    @Test
    public void testFilterOddNumbers() {
        NumberFilter filter = new NumberFilter();
        
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = Arrays.asList(1, 3, 5, 7, 9);

        List<Integer> result = filter.filterOddNumbers(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testFilterOddNumbers_empty_input() {
        NumberFilter filter = new NumberFilter();

        List<Integer> input = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();

        List<Integer> result = filter.filterOddNumbers(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testFilterOddNumbers_null_input() {
        NumberFilter filter = new NumberFilter();

        List<Integer> input = null;
        List<Integer> expected = new ArrayList<>();

        List<Integer> result = filter.filterOddNumbers(input);

        assertThat(result).isEqualTo(expected);
    }
    
}
