package heap.utils;

import java.util.Arrays;

public class MinHeap {

    MergeKSortedEntry arr[];
    int capacity;
    int size;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        size = 0;
        arr = new MergeKSortedEntry[capacity];
    }

    private int getLeftChildIndex(int parent) {
        return (parent * 2) + 1;
    }

    private int getRightChildIndex(int parent) {
        return (parent * 2) + 2;
    }

    private int getLeftChild(int parent) {
        return arr[getLeftChildIndex(parent)].value;
    }

    private int getRightChild(int parent) {
        return arr[getRightChildIndex(parent)].value;
    }

    private boolean hasLeftChild(int parent) {
        return getLeftChildIndex(parent) < size;
    }

    private boolean hasRightChild(int parent) {
        return getRightChildIndex(parent) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getParent(int index) {
        return arr[getParentIndex(index)].value;
    }

    public int getSize(){
        return size;
    }

    private void swap(int current, int parent) {
        MergeKSortedEntry temp = arr[current];
        arr[current] = arr[parent];
        arr[parent] = temp;
    }

    private void heapifyDown() {

        int current = 0;

        while (hasLeftChild(current)) {
            int smallerIndex = getLeftChildIndex(current);

            if (hasRightChild(current) && getLeftChild(current) > getRightChild(current))
                smallerIndex = getRightChildIndex(current);

            if (arr[current].value < arr[smallerIndex].value)
                break;

            swap(current, smallerIndex);
            current = smallerIndex;
        }
    }

    private void heapifyUp() {
        int current = size - 1;

        while (hasParent(current) && arr[current].value < getParent(current)) {
            swap(current, getParentIndex(current));
            current = getParentIndex(current);
        }
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public void insert(int i, int j, int data) throws Exception {

        if (size > capacity) {
            throw new Exception("Size is full");
        }

        arr[size++] = new MergeKSortedEntry(i, j, data);
        heapifyUp();
    }

    public MergeKSortedEntry remove() throws Exception {

        if (size == 0)
            throw new Exception("No Element present in array");

        MergeKSortedEntry data = arr[0];
        arr[0] = arr[--size];
        heapifyDown();
        return data;
    }

    public void printHeap(){
        System.out.println(Arrays.toString(arr));
    }
}