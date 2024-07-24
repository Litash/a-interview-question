package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class NumberFilter {
    public List<Integer> filterOddNumbers(List<Integer> numbers) {
        List<Integer> oddNumbers = new ArrayList<>();
        if(numbers!=null && !numbers.isEmpty()) {
            for (Integer number : numbers) {
                if (number % 2 != 0) {
                    oddNumbers.add(number);
                }
            }
        }
        return oddNumbers;
    }
}
