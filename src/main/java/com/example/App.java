package com.example;

import com.example.algoritmos.parte1;

public class App {
    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int[][] matrix = parte1.generateOrderedMatrix(m, n);
        // int[] result = parte1.linearMatSearch(matrix, matrix[3][4]);
        // int[] result = parte1.successfulMatSearch(matrix, matrix[3][4]);
        // int[] result = parte1.binaryMatSearch(matrix, matrix[3][4]);
        // System.out.printf("%s;%s;%s;%s\n", "Descripcion", "Talla", "Iteraciones",
        // "Resultado");
        // System.out.printf("%s;%d;%d;%s\n", "linearMatSearchMejor", m * n, result[2],
        // "[" + result[0] + "," + result[1] + "]");

        int[] test = parte1.getCoordinates(6, m);

        System.out.println(test[0] + " " + test[1] + " " + matrix[test[0]][test[1]] + " " + matrix[1][0]);
    }

    /// PREGUNTAS///
    // 1.1.1
    // EL coste temporal es n^2 ya que en número de iteraciones es m*n

    // 1.1.2
    // 50*50=2500

    // 1.2.1
    //

    // 1.2.2
    // Si porque el algoritmo de detiene en cuanto encuentra el valor que busca y no
    // tiene la necesidad de recorrer toda la matriz

}
