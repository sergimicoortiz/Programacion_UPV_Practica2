package com.example.algoritmos;

import java.util.function.Function;

public class parte2 {

    private static int randomNum(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static int[] generateOrderedArray(int n) {
        int min = 0;
        int max = 100;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomNum(min, max);
        }
        return arr;

    }

    public static int[] linealSearchIterative(int[] array, int valor) {
        int pos = -1;
        int iterations = 0;
        int[] result = { pos, iterations };
        boolean found = false;
        for (int i = 0; i < array.length && !found; i++) {
            iterations++;
            if (valor == array[i]) {
                pos = i;
                found = true;
            }
        }
        result[0] = pos;
        result[1] = iterations;
        return result;
    }

    public static void medirTiempo() {
        final int INIT_SIZE = 100000, // Talla inicial
                MAX_SIZE = 1000000, // Talla final
                STEP = 100000, // A cada medida, incrementamos la talla en STEP
                REPS = 1000, // Repeticiones para una media más fiable
                ARRAY_SIZE = 100; // Tamaño del array

        int[] array = generateOrderedArray(ARRAY_SIZE);
        int[] result;
        int arraySize, vBest, vWorst;
        long timeEnd, timeStart, tBest, tWorst, tAvr;

        System.out.printf("%10s;%10s;%10s;%10s\n", "Talla", "Mejor", "Peor",
                "Promedio");

        for (int size = INIT_SIZE; size <= MAX_SIZE; size += STEP) {
            array = generateOrderedArray(size);
            arraySize = array.length;

            vBest = array[0];
            vWorst = array[arraySize - 1];

            timeStart = System.nanoTime();
            for (int rep = 0; rep < REPS; rep++) {
                result = linealSearchIterative(array, vBest);
            }
            timeEnd = System.nanoTime();
            tBest = (timeEnd - timeStart) / REPS;
            // Implementar el cálculo para el peor valor
            timeStart = System.nanoTime();
            for (int rep = 0; rep < REPS; rep++) {
                result = linealSearchIterative(array, vWorst);
            }
            timeEnd = System.nanoTime();
            tWorst = (timeEnd - timeStart) / REPS;
            // Implementar el cálculo para el valor promedio
            tAvr = (tBest + tWorst) / 2;
            System.out.printf("%10d;%10d;%10d;%10d\n", size, tBest, tWorst, tAvr);
        }
    }

}
