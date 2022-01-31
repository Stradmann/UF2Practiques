
package handy;

public class ArrayManager {
    
    public static void initializeToZero(int[] nArray){
        for(int i = 0; i < nArray.length; i++){
            nArray[i] = 0;
        }
    }
    //COPY ARRAY
    public static void copyArray(int[] copy, int[] paste){
        for (int i = 0; i < copy.length; i++){
            paste[i] = copy[i];
        }
    }
    //REMOVE ONE
    public static int[] removeOne(int[] nArray, int iToRemove){
        
        int[] result = new int[nArray.length - 1];
        
        int j = 0;
        for(int i = 0; i < nArray.length; i++){
            if( i != iToRemove){
                result[j] = nArray[i];
                j++;
            }
        }
        
        return result;
    }
    
}