package org.example.arrays;

public class MySimpleArrayOperations {

    public int findMin(int[] array) {
        if(!(array.length > 0)) {
            throw new IllegalArgumentException("Input array is empty");
        }

        int min = Integer.MAX_VALUE;
        for (int j : array) {
            if (j <= min)
                min = j;
        }
        return min;
    }

    public void multiply(int[] array, int factor) {
        if(!(array.length > 0)) {
            throw new IllegalArgumentException("Input array is empty");
        }

        for( int i=0; i<array.length; i++ ) {
            array[i] = array[i] * factor;
        }
    }
}