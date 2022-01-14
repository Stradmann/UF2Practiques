/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*Escriu una funció anomenada “Maxim” al que se li passa un vector d’enters i
ha de tornar el més gran dels números que conté el vector.*/
package Practica6;

import java.util.Scanner;

/**
 *
 * @author enric
 */
public class Exercici3 {

    static int Maxim(int v[]) {
        int max = v[0];
        for (int i = 1; i < v.length; i++) {
            if (v[i] > max) {
                max = v[i];
            }
        }
        return max;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        //validar la dimensio del vector establint un rang dels valors limitats.
        int dim = handy.Validator.readInt("Introdueix la dimensio del vector: ", 1, Integer.MAX_VALUE);
        final int DIM = dim;
        int v[] = new int[DIM];

        for (int i = 0; i < v.length; i++) {
            v[i] = handy.Validator.readInt("Introdueix el valor " + (i + 1) + " : ");
        }
        int max;
        max = Maxim(v);
        System.out.println("El maxim del vector sera: " + max);
    }
}
