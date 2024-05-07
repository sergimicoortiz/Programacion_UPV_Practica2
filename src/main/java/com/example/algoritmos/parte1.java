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
        int[] xy = { -1, -1 };
        xy[0] = indice / ancho;
        xy[1] = indice % ancho;
        return xy;
    }

    public static int[] binaryMatSearch(int[][] matrix, int target) {
        // 1. Calculate number of rows
        int rows = matrix.length;
        // 2. Calculate number of columns
        int columns = matrix[0].length;
        // 3. Set the start index as 0
        int start_index = 0;
        // 4. Set the last index as the position of the last element
        int last_index = (rows * columns) - 1;
        int cont = 0;
        int[] result = { -1, -1, cont };

        // 5. While the start index is lower or equals than the last index
        while (start_index <= last_index) {
            cont++;
            // 5.1 Calculate the index for the mid position, as an integer
            int mid_index = start_index + ((last_index - start_index) / 2);
            // 5.2 Translate this index to 2D coordinates (using your function)
            int[] mid_pos = getCoordinates(mid_index, columns);
            // 5.3 Get the value from the matrix in the mid position
            int mid_value = matrix[mid_pos[0]][mid_pos[1]];
            // 5.4 If the value at the mid position is the same as target
            if (mid_value == target) {
                // 5.5 Return the 2D coordinates where it is located
                result[0] = mid_pos[0];
                result[1] = mid_pos[1];
                result[2] = cont;
                return result;
                // 5.6 Else-If the value at the mid position is lower than the target
            } else if (mid_value < target) {
                // 5.7 Set the start index to the mid index + 1
                start_index = mid_index + 1;
                // 5.8 Else (the value at the mid position is higher than the target)
            } else {
                // 5.9 Set the last index to mid - 1
                last_index = mid_index - 1;
            }
        }
        // 6. Executing this code means target is not in the array, return [-1,-1]
        result[2] = cont;
        return result;
    }

    public static int[] binaryMatRecursiveSearch(int[][] mat, int target, int inicio, int fin, int cont) {
        int columns = mat[0].length;
        int[] result = { -1, -1, cont };
        if (inicio > fin) {
            return result;
        }
        cont++;
        int mid_index = inicio + ((fin - inicio) / 2);
        int[] mid_pos = getCoordinates(mid_index, columns);
        int mid_value = mat[mid_pos[0]][mid_pos[1]];
        if (mid_value == target) {
            result[0] = mid_pos[0];
            result[1] = mid_pos[1];
            result[2] = cont;
            return result;
        } else if (mid_value < target) {
            inicio = mid_index + 1;
        } else {
            fin = mid_index - 1;
        }

        return binaryMatRecursiveSearch(mat, target, inicio, fin, cont);
    }

}
