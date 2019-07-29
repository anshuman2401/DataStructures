package tree.solutions;

public class SegmentTree {

    private int[] segTree;

    private SegmentTree(int n) {
        int x = (int)Math.ceil((Math.log(n) / Math.log(2)));
        int max_size = 2 * (int)Math.pow(2, x) - 1;

        segTree = new int[max_size];
    }

    private void constructTree(int[] arr, int n){
        constructTreeUtil(arr, 0, n-1 , 0);
    }

    private int constructTreeUtil(int[] arr, int start, int end, int index){

        if(start == end){
            return segTree[index] = arr[start];
        }

        int mid = start + (end - start) / 2;
        segTree[index] = Math.min(constructTreeUtil(arr, start, mid, (index * 2) + 1),
                constructTreeUtil(arr, mid + 1, end, (index * 2) + 2));

        return segTree[index];
    }

    private int minRange(int n, int qs, int qe){

        if(qs < 0 || qe < 0 || qs > qe || qs > n - 1 || qe > n - 1)
            return -1;

        return minRangeUtil(qs, qe, 0 , n-1, 0);
    }

    private int minRangeUtil(int qs, int qe, int start,int end, int index){

        if(qs <= start && qe >= end)
            return segTree[index];

        if (end < qs || start > qe)
            return Integer.MAX_VALUE;

        int mid = (start + end) / 2;

        return Math.min(minRangeUtil(qs, qe, start, mid, (index * 2) + 1),
                minRangeUtil(qs, qe, mid + 1, end,(index * 2) + 2));
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,7,9,11};
        int n = arr.length;

        SegmentTree tree = new SegmentTree(n);
        tree.constructTree(arr, n);

        int qs = 1;
        int qe = 5;

        System.out.println("Minimum of values in range [" + qs + ", "
                + qe + "] is = " + tree.minRange(n, qs, qe));
    }
}
