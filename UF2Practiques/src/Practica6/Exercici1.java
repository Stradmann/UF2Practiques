/*1. Escriu una funció anomenada “QuiEsIntegrantDAquestGrup” que, rebi com a
paràmetre un número enter i, i retorni el membre i-ésim del grup. Si no hi ha
membre i-ésim ha de tornar una cadena buida.
Exemple: Tenim un grup format per Lluis(1) i Marta(2)
Si demano QuiEsIntegrantDAquestGrup(2) m’ha de tornar “Marta”
Si demano QuiEsIntegrantDAquestGrup(0) m’ha de tornar “”
Si demano QuiEsIntegrantDAquestGrup(3) m’ha de tornar “”*/

package Practica6;

public class Exercici1 {

    public static String QuiEsIntegrantDAquestGrup(int numero) {
        
        String result;
        switch (numero) {
            case 1:
                result = "Enric";
                break;
            case 2:
                result = "Yenifer";
                break;
            case 3:
                result = "Andrés";
                break;
            default:
                result = "";
        }
        
        return result;
    }
}
