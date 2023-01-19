package org.example.arrays;

import java.util.List;

public class Lists {

    List<Integer> removeNegativeNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n >= 0).toList();
    }

    List<Integer> multiplyOddNumbersBy2(List<Integer> numbers) {
        return numbers.stream().map(n -> {
            if (n % 2 == 1) {
                return n * 2;
            }
            return n;
        }).toList();
    }

    List<Integer> createListWith3Numbers(){
        return List.of(1,2,3);
    }
}
