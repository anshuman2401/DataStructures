package heap.solutions;

import heap.utils.MergeKSortedEntry;
import heap.utils.MinHeap;

public class MergeKSortedArrays {

    public static void main(String[] args) throws Exception{
        int k = 3, n =  4;
        int[][] arr = { {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}} ;

        mergeKSortedArrays(arr, k, n);
    }

    private static void mergeKSortedArrays(int[][] arr, int k, int n) throws Exception{

        MinHeap heap = new MinHeap(3);

        for(int i = 0; i < k; i++){
            heap.insert(i, 0, arr[i][0]);
        }

        while(!heap.isEmpty()){

            MergeKSortedEntry entry = heap.remove();
            System.out.print(entry.value + " ");

            if(entry.j + 1 < n)
                heap.insert(entry.i, entry.j+1, arr[entry.i][entry.j+1]);
        }
    }
}


