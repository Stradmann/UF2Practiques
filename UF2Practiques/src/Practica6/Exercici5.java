/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*. Escriu una funció “MCD_Euclides” que retorni el màxim comú divisor de dos
números segons l’algorisme d’Euclides. Aquest algorisme el podeu trobar
detallat a https://ca.wikipedia.org/wiki/Algorisme_d%27Euclides */
package Practica6;

import java.util.Scanner;

/**
 *
 * @author enric
 */
public class Exercici5 {

    /**
     *
     * @param a
     * @param b
     * @return
     */
    static int MCD_Euclides(int a, int b) {
        int resultat = 0;
        int aux;
        //trobar el mcd dels dos divisors
        while (b != 0) {
            aux = b;
            b = a % b;
            a = aux;
        }
        resultat = a;
        return resultat;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int divA = handy.Validator.readInt("Introdueix el 1r divisor: ");
        int divB = handy.Validator.readInt("Introdueix el 2n divisor: ");
        int mcd = MCD_Euclides(divA, divB);
        System.out.println("El maxim comu divisor de " + divA + " i " + divB + " sera: " + mcd);
    }
}
