package com.codecool.hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K, V> {

    // Number of all buckets - Do not modify!
    private final int bucketsSize = 16;

    private List<Entry<K, V>> buckets;
    private V tmpValue;

    public HashTable() {
        buckets = new ArrayList<>();
    }

    private int getBucketIndexForKey(K key) {
        for (int i = 0; i < bucketsSize; i++) {
            if (buckets.get(i).key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private Entry<K, V> getBucketAtIndex(int position) {
        return buckets.get(position);
    }

    private Entry<K, V> findEntryInBucket(K key) {
        for (Entry<K, V> entry : buckets) {
            if (entry.key.equals(key)) {
                return entry;
            }
        }
        return null;
    }

    public V get(K key) {
        if (key == null){
            return tmpValue;
        }
        for (Entry<K, V> entry : buckets) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        if (key == null){
            tmpValue = value;
        } else if (buckets.size() == 0) {
            buckets.add(new Entry<>(key, value));
        }
        for (int i = 0; i < buckets.size(); i++) {
            if (buckets.get(i).key.equals(key)) {
                buckets.get(i).value = value;
            } else if (i == buckets.size() - 1) {
                buckets.add(new Entry<>(key, value));
            }
        }
    }

    public V remove(K key) {
        for (Entry<K, V> entry : buckets) {
            if (entry.key.equals(key)) {
                V value = entry.value;
                buckets.remove(entry);
                return value;
            }
        }
        return null;
    }

    public void clear() {
        buckets = new ArrayList<>();
    }
}

class Entry<K, V> {

    public K key;
    public V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

}
