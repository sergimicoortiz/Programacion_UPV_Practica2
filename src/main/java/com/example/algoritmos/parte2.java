package com.example.algoritmos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class parte2 {

    public static int[] generateOrderedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
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

    @SuppressWarnings("unused")
    public static void medirTiempo() {
        final int INIT_SIZE = 100000, // Talla inicial
                MAX_SIZE = 1000000, // Talla final
                STEP = 100000, // A cada medida, incrementamos la talla en STEP
                REPS = 1000; // Repeticiones para una media más fiable

        int[] result, array;
        int arraySize, vBest, vWorst, vAvr;
        long timeEnd, timeStart, tBest, tWorst, tAvr;

        try {
            PrintStream csvPrintStream = new PrintStream(new FileOutputStream("output.csv"));
            csvPrintStream.printf("%10s;%10s;%10s;%10s\n", "Talla", "Mejor", "Peor",
                    "Promedio");

            for (int size = INIT_SIZE; size <= MAX_SIZE; size += STEP) {
                array = generateOrderedArray(size);
                arraySize = array.length;

                vBest = array[0];
                vWorst = array[arraySize - 1];
                vAvr = array[arraySize / 2];

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
                timeStart = System.nanoTime();
                for (int rep = 0; rep < REPS; rep++) {
                    result = linealSearchIterative(array, vAvr);
                }
                timeEnd = System.nanoTime();
                tAvr = (timeEnd - timeStart) / REPS;
                csvPrintStream.printf("%10d;%10d;%10d;%10d\n", size, tBest, tWorst, tAvr);
            }
            csvPrintStream.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: No se pudo abrir archivo CSV" + e);
        }
    }

}
