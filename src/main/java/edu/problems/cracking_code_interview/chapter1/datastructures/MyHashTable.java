package edu.problems.cracking_code_interview.chapter1.datastructures;

public class MyHashTable<K,V> {

    class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private static final int MAX_LOAD_FACTOR = 75; // percentage
    private int size = 0;

    private Entry<K,V>[] table;

    public MyHashTable(int size){
        table = new Entry[size];
    }

    public void put(K key, V value){
        int index = Math.abs(key.hashCode()) % table.length;
        Entry<K,V> entry = new Entry<>(key,value);
        entry.next = table[index];
        table[index] = entry;
        size++;

        // Check load factor and resize if needed
        int loadFactor = (size * 100) / table.length;
        if (loadFactor > MAX_LOAD_FACTOR) {
            resize();
        }
    }


    public V get(K key){
        int index = Math.abs(key.hashCode()) % table.length;
        Entry<K,V> entry = table[index];
        while (entry != null){
            if(entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public boolean remove(K key){
        int index = Math.abs(key.hashCode()) % table.length;
        Entry<K,V> entry = table[index];
        Entry<K,V> prevEntry = null;
        while (entry != null){
            if(entry.key.equals(key)){
                // If this entry is the head of the chain, set the next entry as the new head
                if(prevEntry == null){
                    table[index] = entry.next;
                } else {
                    // If this entry is not the head of the chain, set the next entry of the previous entry as this entry's next
                    prevEntry.next = entry.next;
                }
                return true;
            }
            prevEntry = entry;
            entry.next = entry;//wrong ?
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K,V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;

        for (Entry<K,V> oldEntry : oldTable) {
            while (oldEntry != null) {
                put(oldEntry.key, oldEntry.value);
                oldEntry = oldEntry.next;
            }
        }
    }
}
