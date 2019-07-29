package sorting;

import java.util.Arrays;

public class MergeSort {

    private static void sortArray(int[] arr){
        sortArrayUtil(arr, 0, arr.length-1);
    }

    private static void sortArrayUtil(int[] arr, int low, int high){

        if(low < high){

            int mid = low + (high - low) / 2;

            sortArrayUtil(arr, low, mid);
            sortArrayUtil(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {

        int firstStart = low;
        int secondStart = mid+1;

        int temp[] = new int[high-low+1];
        int index = 0;

        while (firstStart <= mid && secondStart <= high){

            if(arr[firstStart] <= arr[secondStart])
                temp[index++] = arr[firstStart++];
            else
                temp[index++] = arr[secondStart++];
        }

        while(firstStart <= mid){
            temp[index++] = arr[firstStart++];
        }

        while (secondStart <= high){
            temp[index++] = arr[secondStart++];
        }

        for (int i = low; i <= high; i++){
            arr[i] = temp[i-low];
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        Arrays.sort(arr);
        sortArray(arr);

        System.out.print(Arrays.toString(arr));
    }
}
