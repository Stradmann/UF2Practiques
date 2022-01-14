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
public class Exercici1 {

    public static void QuiEsIntegrantDAquestGrup(int numero) {
        switch (numero) {
            case 1:
                System.out.println("Enric");
                break;
            case 2:
                System.out.println("Yenifer");
                break;
            case 3:
                System.out.println("Andrés");
                break;
            default:
                System.out.println("Has introduit un numero incorrecte ja que només hi han 3 integrants en el grup");
        }
    }
}
