package com.ba.EvaluacionKevinBarzallo.utils;

import java.util.Arrays;

public class AlgorithmsUtils {

    public static void printNumbersOneToHundred(){

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("SOMOS BA");
            } else if (i % 3 == 0) {
                System.out.println("SOMOS");
            } else if (i % 5 == 0) {
                System.out.println("BA");
            } else {
                System.out.println(i);
            }
        }

    }

    public static Boolean isAnagram(String str1, String str2) {
        // primero comprobamos los tamonos de los strings
        int n1 = str1.length();
        int n2 = str2.length();
        // si no son iguales, no son anagramas
        if (n1 != n2)
            return false;
        // ordenamos los strings
        str1 = sortString(str1);
        str2 = sortString(str2);

        // comprobamos si son iguales
        for (int i = 0; i < n1; i++)
            if (str1.charAt(i) != str2.charAt(i))
                return false;
        return true;
    }

    // funcion para ordenar los strings
    static String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        str = String.valueOf(charArray);
        return str;
    }

    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        int temp = 0;
        // recorremos el array
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < (n-i); j++) {
                if(array[j-1] > array[j]) {
                    // intercambiamos los elementos
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }

            }
        }
        return array;
    }



}
