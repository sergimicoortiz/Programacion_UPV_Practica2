package com.example;

import com.example.algoritmos.parte1;
import com.example.algoritmos.parte2;

@SuppressWarnings("unused")
public class App {

    public static void main(String[] args) {
        ///// PARTE1/////

        // int m = 5;
        // int n = 5;
        // int[][] matrix = parte1.generateOrderedMatrix(m, n);
        // int[] result = parte1.linearMatSearch(matrix, matrix[3][4]);
        // int[] result = parte1.successfulMatSearch(matrix, matrix[3][4]);
        // int[] result = parte1.binaryMatSearch(matrix, matrix[3][4]);
        // int[] result = parte1.binaryMatRecursiveSearch(matrix, matrix[3][4], 0, (m *
        // n) - 1, 0);
        // System.out.printf("%s;%s;%s;%s\n", "Descripcion", "Talla", "Iteraciones",
        // "Resultado");
        // System.out.printf("%s;%d;%d;%s\n", "linearMatSearchMejor", m * n, result[2],
        // "[" + result[0] + "," + result[1] + "]");

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

        // 1.3.1
        // Mejor que sea el del medio, peor que sea uno de los extremos (primer o ultimo
        // elemento de la array)

        // 1.3.2
        // Realizara solo una iteracion ya que el algoritmo empieza a buscar por el
        // elemento del centro.

        // 1.3.3
        // 2500 iteraciones

        // 1.4.1
        // El resultado es el mismo que el anterior

        // 1.4.2
        // Nos da stack overflow

        ///// PARTE2/////
        parte2.medirTiempo();

    }
}
