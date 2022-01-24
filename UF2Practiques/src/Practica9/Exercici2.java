/*2. Implementa una versió recursiva de l’algorisme d’Euclides que consisteix en
restar el número més petit del més gran fins que quedin dos números iguals.
En aquest moment, aquest número és el màxim comú divisor de tots dos
números.
Exemple: si busquem el màxim comú divisor de 412 i 184 tindríem:
412 228 44 44 44 44 44 36 28 20 12 4 4
184 184 184 140 96 52 8 8 8 8 8 8 4*/

package Practica9;

public class Exercici2 {
    public static void main(String[] args){
        System.out.println(euclidesMCD(412, 184));
    }
    
    public static int euclidesMCD(int a, int b){
        int result;
        if(a == b){
            result = a;
        }else{
            int rest = Math.abs(a - b);
            if(a > rest && a > b){
                result = euclidesMCD(b, rest);
            }else{
                result = euclidesMCD(a, rest);
            }
        }
        return result;
    }
}
