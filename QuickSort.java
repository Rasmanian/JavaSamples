import java.util.*;

class QuickSort {

    private int[] input;
    private int length;

    public void sort(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return;
        }
        this.input = numbers;
        length = numbers.length;
        quickSort(0, length - 1);
    }

    /*
     * This method implements in-place quicksort algorithm recursively.
     */
    private void quickSort(int low, int high) {
        int i = low;
        int j = high;

        // pivot is middle index
        int pivot = input[low + (high - low) / 2];
        
        System.out.println("Pivot is : " + pivot);

        // Divide into two arrays
        while (i <= j) {
            /**
             * As shown in above image, In each iteration, we will identify a
             * number from left side which is greater then the pivot value, and
             * a number from right side which is less then the pivot value. Once
             * search is complete, we can swap both numbers.
             */
            while (input[i] < pivot) {
                i++;
            }
            while (input[j] > pivot) {
                j--;
            }
            if (i <= j) {
                System.out.println("i, j and Array is : " + i + "," + j + " : " + Arrays.toString(input));
                swap(i, j);
                System.out.println("i, j and Array is : " + i + "," + j + " : " + Arrays.toString(input));
                // move index to next position on both sides
                i++;
                j--;
            }
        }

        // calls quickSort() method recursively
        if (low < j) {
            quickSort(low, j);
        }

        if (i < high) {
            quickSort(i, high);
        }
    }

    private void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    
    
    public static void main(String [] args)
    {
        int[] numbers = {1,2,3,4,5,9,6,7,8};
        QuickSort qs = new QuickSort();
        qs.sort(numbers);
       
    }
}


