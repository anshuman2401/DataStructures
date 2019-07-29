package sorting;

import java.util.Arrays;

public class QuickSort {

    private static void sortArr(int[] arr) {

        sortArrUtil(arr, 0, arr.length - 1);

        System.out.print(Arrays.toString(arr));
    }

    private static void sortArrUtil(int[] arr, int low, int high){

        if(low < high){

            int partition = partition(arr, low, high);

            sortArrUtil(arr, low, partition-1);
            sortArrUtil(arr, partition + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){

        int pivot = arr[high];
        int i = low - 1;

        for(int j = low; j < high; j++) {

            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, high);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {3,21,1,6,33,2,67,4};

        sortArr(arr);
    }
}
