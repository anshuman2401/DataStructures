package systemdesign;

import java.util.HashMap;

public class LRU {

    private int capacity;
    private HashMap<Integer, Entry> map = new HashMap<>();
    private Entry start,end;

    private LRU(int capacity){
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRU lru = new LRU(4);

        lru.putEntry(1, 1);
        lru.putEntry(10, 15);
        lru.putEntry(15, 10);
        lru.putEntry(10, 16);
        lru.putEntry(12, 15);
        lru.putEntry(18, 10);
        lru.putEntry(13, 16);

        System.out.println(lru.getEntry(1));
        System.out.println(lru.getEntry(10));
        System.out.println(lru.getEntry(15));
    }

    private void putEntry(int key, int value){

        if(map.containsKey(key)){
            Entry entry = map.get(key);
            entry.value = value;
            removeNode(entry);
            addAtTop(entry);
        }else{
            Entry entry = new Entry();
            entry.key = key;
            entry.value = value;

            if(map.size() > capacity){
                map.remove(end.key);
                removeNode(end);
            }

            addAtTop(entry);
            map.put(key, entry);
        }
    }

    private int getEntry(int key){

        if(map.containsKey(key)){
            Entry entry = map.get(key);
            removeNode(entry);
            addAtTop(entry);
            return entry.value;
        }
        return -1;
    }

    private void addAtTop(Entry entry){

        entry.right = start;

        if (start != null){
            start.left = entry;
        }

        start = entry;

        if(end == null)
            end = entry;
    }

    private void removeNode(Entry entry){
        if(entry.left != null)
            entry.left.right = entry.right;
        else
            start = entry.right;

        if (entry.right != null)
            entry.right.left = entry.left;
        else
            end = entry.left;
    }
}

class Entry{
    int key,value;
    Entry left,right;
}