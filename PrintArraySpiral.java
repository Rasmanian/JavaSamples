import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
  

class PrintArraySpiral {

    public static void printArray(int[][] array) 
    {
        int length = array[0].length;
        int depth = array.length;
        
        int noOfCycles = length > depth ? depth / 2 : length / 2;
        
            
        System.out.println("No of cycles : " + noOfCycles); 
        
        for (int n = 0; n < noOfCycles; n++)
        {
            int i = n; 
            int j = n;
            int edgelenth = length - n;
            int edgeDepth = depth - n;
            
            System.out.println("edgelenth : " + edgelenth); 
            System.out.println("edgeDepth : " + edgeDepth); 
            
            while (i < edgelenth && j < edgeDepth)
            {
                System.out.println(array[j][i]);  
                if (i < edgelenth - 1) i ++;
                else if (j < edgeDepth - 1 ) j ++; 
                else break;

            }
            

            // Second half
            
            while (i >= n && j >= n)
            {
                
                if (i > n) i --;
                else if (j > n) j --;
                   
                if (j > n)
                    System.out.println(array[j][i]);  
                else
                    break;
            }
        }
        
        // Non Square edge case
        if (depth > length)
        {
            int i = noOfCycles;
            int j = noOfCycles;
            
            while (j < depth - noOfCycles)
            {
                System.out.println(array[j][i]);
                j++;
                
            }
        }
        else if (length > depth)
        {
            int i = noOfCycles;
            int j = noOfCycles;
            
            while (i < length - noOfCycles)
            {
                System.out.println(array[j][i]);
                i++;
                
            }
        }
    }
    
    public static void main(String args[])
    {
        int[][] array = { {1, 2, 3, 4, 5}, 
                                        {6, 7, 8, 9, 10}, 
                                        {11, 12, 13, 14, 15}}; 
    
        printArray(array);
    
    }

}
