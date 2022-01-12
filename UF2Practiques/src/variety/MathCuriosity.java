
package variety;


public class MathCuriosity {
    
    public static boolean isPerfect(int x){
        boolean result;
        
        int sum = 0;
        for(int i = 1; i < x; i++){
            if(x % i == 0)
                sum += i;
        }
        if(sum == x)
            result = true;
        else
            result = false;
        
        return result;
    }
    
    public static boolean isCapicua(int x){
        boolean result;
        String xStr = String.valueOf(x);
        
        result = true;
        int j = xStr.length() - 1;
        for(int i = 0; i <= j && result == true; i++){
            if(Character.compare(xStr.charAt(i), xStr.charAt(j)) != 0){
                result = false;
            }else{
               j--; 
            }    
        }
        
        return result;
    }
    
    public static boolean isTriangle(float a, float b, float c){
        boolean result;
        
        if(Math.abs(a - c) < b && b < (a + c)){
            result = true;
        }else{
            result = false;
        }
        
        return result;
    }
    
    public static float triangleArea(float a, float b, float c){
        
        float area;
        float s = (a + b + c) / 2;
        
        area = (float)Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return area;
    }
}
