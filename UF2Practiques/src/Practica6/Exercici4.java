/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica6;

/**
 *
 * @author enric
 */
public class Exercici4 {
    public static void Dau() {
        final int MAX = 6, MIN = 1;
        int numero_aleatori = (int) (Math.random() * (MAX - MIN + 1) + MIN);
        System.out.println(numero_aleatori);
    }
    
    public static void main(String[] args) {
        System.out.println("Dao llanḉat, el número que ha sortit es: ");
        Dau();
    }
}
