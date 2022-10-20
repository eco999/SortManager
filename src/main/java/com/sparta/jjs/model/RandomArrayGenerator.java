package com.sparta.jjs.model;

import java.util.Random;

public class RandomArrayGenerator {

    public static int[] generateRandomArray(int arrayLength)
    {
        Random random = new Random();
        int[] randomArray = new int[arrayLength];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(1000);
        }
        return randomArray;
    }
}
