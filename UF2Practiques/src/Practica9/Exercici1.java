/*Implementa una versió iterativa de les següents funcions:
a) int m1(int n)
{
if (n == 0) return 1;
else return n * m1 (n-1);
}
b) int m2(double x, int n)
{
if (n == 0) return 0;
else return n + m2 (x, n-1);
}
c) int m3( int n)
{
if (n < 2 ) return 0;
else return 1 + m3 (n/2);
}
d) int m4( int n)
{
if (n == 0) return 0;
else return m4 (n / 10) + n % 10;
}*/

package Practica9;

public class Exercici1 {
    public static void main(String[] args){
        
    }
    
    public static int m1(int n){
        int result = 1;
        for(int i = 1; i <= n; i++){
            result *= i;
        }
        
        return result;
    }
    
    public static int m2(int n){
        int result = 0;
        for(int i = 0; i <= n; i++){
            result += i;
        }
        
        return result;
    }
    
    public static int m3(int n){
        int result = 0;
        int i;
        for(i = 0; n >= 2; i++){
            n /= 2;
        }
        result = i;
        return result;
    }
    
    public static int m4(int n){
        int result = 0;
        while(n != 0){
            result += n % 10;
            n /= 10;
        }
        
        return result;
    }
}