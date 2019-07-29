package heap.utils;

public class MergeKSortedEntry {
    public int i, j, value;

    public MergeKSortedEntry(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
