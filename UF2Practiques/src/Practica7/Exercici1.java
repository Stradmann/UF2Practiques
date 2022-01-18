/*1. Escriu una funció anomenada “CalcularDescompte” que, rebi com a
paràmetres el preu i la categoria d’un producte i retorni el preu amb el
descompte aplicat. Les categories poden ser de 3 tipus: A, B i C. Els productes
de categoria A tenen un 5% de descompte, els de categoria B un 10% de
descompte i els de categoria C tenen un 20% de descompte si el preu és
inferior a 100€ i de 35% si el preu és igual o superior a 100€.*/
package Practica7;
import handy.Validator;
import java.util.Scanner;

/**
 *
 * @author ausias
 */

/*1. Escriu una funció anomenada “CalcularDescompte” que, rebi com a
paràmetres el preu i la categoria d’un producte i retorni el preu amb el
descompte aplicat. Les categories poden ser de 3 tipus: A, B i C. Els productes
de categoria A tenen un 5% de descompte, els de categoria B un 10% de
descompte i els de categoria C tenen un 20% de descompte si el preu és
inferior a 100€ i de 35% si el preu és igual o superior a 100€.*/
public class Exercici1 {

    static double CalcularDescompte(double preu, String categoria) {
        double preuFinal = 0;
        switch (categoria) {
            case "A":
            case "a":
                preuFinal = preu * 0.95;
                break;
            case "B":
            case "b":
                preuFinal = preu * 0.90;
                break;
            case "C":
            case "c":
                if (preu < 100) {
                    preuFinal = preu * 0.80;
                } else {
                    preuFinal = preu * 0.65;
                }
                break;
            default:
                System.out.println("Error: Categoria no valida");
        }
        return preuFinal;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        String categoria = handy.Validator.readString("Introdueix la categoria del producte (A/B/C): ");
        double preu = handy.Validator.readFloat("Introdueix el preu del producte: ", 1, Integer.MAX_VALUE);
        double preuFinal = CalcularDescompte(preu, categoria);
        System.out.println("El preu total del producte " + categoria + " sera: " + preuFinal);

    }
}
