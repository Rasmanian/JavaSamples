import java.util.*;

class ProductsOfAllIntsExceptAtIndex {
    
// General solution is using TWO loops is not efficient - O of N sq complexity.
    
    
    // GREEDY APPRAOCH with O of N (1 loop) and O of N space  (new Arrays are needed of the Size N)
    // We would like to use the result of multiplications Before and After.
    
    public static int[] getProductsOfAllIntsExceptAtIndex(int[] values) {
        
        int[] result = new int[values.length];  
        Arrays.fill(result, 1);
       
        int[] resultBefore = new int[values.length]; 
        Arrays.fill(resultBefore, 1);
        
        int[] resultAfter = new int[values.length];
        Arrays.fill(resultAfter, 1);

// TIP we can use only ONE array too; Store the Before in this array first and then multiply by After; but this will need a 
// TEMP variable inside the FOR Loop to store the prev value instead of referring to the Array;
// TWO LOOPS and one Array will be needed in this case above.
        
        for (int i = 1; i < values.length; i++)
        {
            resultBefore[i] = resultBefore[i-1] * values[i-1];
            //System.out.println(resultBefore[i]);
        }
        
        for (int i = values.length - 2; i >= 0; i--)
        {
            resultAfter[i] = resultAfter[i+1] * values[i+1];            
            //System.out.println(resultAfter[i]);
        }
        
        for (int i = 0; i < values.length; i++)
        {
             System.out.println(resultBefore[i] + ":" + resultAfter[i]);
             result[i] = resultBefore[i] * resultAfter[i];
        }
        
        return result;
        
    }
    
    
    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        //String testInput = "test input";
        System.out.println(Arrays.toString(
                        getProductsOfAllIntsExceptAtIndex(new int[]{1, 2, 6, 5, 9})
                                          )
                          );
        
        // System.out.println(Math.random());
        
    }
}