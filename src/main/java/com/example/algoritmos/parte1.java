package com.example.algoritmos;

import java.util.Random;

public class parte1 {

    public static int[][] generateOrderedMatrix(int m, int n) {
        Random rand = new Random();
        int[][] matrix = new int[m][n];
        int value = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                value += rand.nextInt(9) + 1;
                matrix[i][j] = value;
            }
        }
        return matrix;
    }

    public static int[] linearMatSearch(int[][] mat, int valor) {
        int counter = 0;
        int[] result = { -1, -1, counter };
        int x = mat[0].length;
        int y = mat.length;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                counter++;
                if (mat[i][j] == valor) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        result[2] = counter;
        return result;
    }

    public static int[] successfulMatSearch(int[][] mat, int valor) {
        int counter = 0;
        int[] result = { -1, -1, counter };
        int x = mat[0].length;
        int y = mat.length;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                counter++;
                if (mat[i][j] == valor) {
                    result[0] = i;
                    result[1] = j;
                    result[2] = counter;
                    return result;
                }
            }
        }
        return result;
    }

    public static int[] getCoordinates(int indice, int ancho) {
        // TODO: revisar
        int[] xy = { -1, -1 };
        xy[1] = indice / ancho;
        xy[0] = indice % ancho;
        return xy;
    }

    public static int[] binaryMatSearch(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int index = 0;
        int last_index = (rows * columns) - 1;
        int cont = 0;
        int[] result = { -1, -1, cont };

        while (index <= last_index) {
            cont++;
            int mid_index = last_index / 2;
            int[] mid_pos = getCoordinates(mid_index, columns);
            int mid_value = matrix[mid_pos[0]][mid_pos[1]];
            if (mid_value == target) {
                result[0] = mid_pos[0];
                result[1] = mid_pos[1];
                result[2] = cont;
                return result;
            } else if (mid_value < target) {
                index = mid_index + 1;
            } else {
                index = mid_index - 1;
            }
        }
        result[2] = cont;
        return result;
    }
}
