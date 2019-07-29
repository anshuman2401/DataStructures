package sorting;

import java.util.Arrays;

/*
   Time Complexity: O(n*2)
   Auxiliary Space: O(1)
   Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order.
                   And it takes minimum time (Order of n) when elements are already sorted.
   Algorithmic Paradigm: Incremental Approach
   Sorting In Place: Yes
   Stable: Yes
*/

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = {3,21,1,6,33,2,67,4};

        sortArr(arr);

        System.out.print(Arrays.toString(arr));
    }

    private static void sortArr(int[] arr) {
        int n = arr.length;

        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i-1;

            while(j >=0 && arr[j] > key){
                arr[j+1] = arr[j--];
            }

            arr[j+1] = key;
        }
    }
}
