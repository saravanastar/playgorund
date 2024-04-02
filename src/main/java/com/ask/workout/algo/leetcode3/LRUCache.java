package com.ask.workout.algo.leetcode3;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Map<Integer, DataNode> lookup;
    DataNode head, tail;

    int capacity = 0;
    int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lookup = new HashMap<>();
        head = new DataNode();
        tail = new DataNode();
        head.next = tail;
        tail.prev = head;
    }

    private void moveToHead(DataNode dataNode) {
        dataNode.next = head.next;
        dataNode.next.prev = dataNode;
        dataNode.prev = head;
        head.next = dataNode;
        lookup.put(dataNode.key, dataNode);
    }

    private void remove(DataNode dataNode) {
        dataNode.prev.next= dataNode.next;
        dataNode.next.prev= dataNode.prev;
        lookup.remove(dataNode.key);
    }
    public int get(int key) {
        DataNode dataNode = lookup.get(key);
        if (dataNode == null) {
            return -1;
        }
        remove(dataNode);
        moveToHead(dataNode);
        return dataNode.value;
    }

    public void put(int key, int value) {
        DataNode dataNode = lookup.get(key);
        if (dataNode != null) {
            dataNode.value = value;
            remove(dataNode);
            moveToHead(dataNode);
        } else {
            dataNode = new DataNode();
            dataNode.key = key;
            dataNode.value = value;
            if (size >= capacity) {
                remove(tail.prev);
            } else {
                size++;
            }
            moveToHead(dataNode);
        }
        lookup.put(key, dataNode);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2, 6);
        System.out.println(lruCache.get(1));
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));


//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1, 1);
//        lruCache.put(2, 2);
//        System.out.println(lruCache.get(1));
//        lruCache.put(3, 3);
//        System.out.println(lruCache.get(2));
//        lruCache.put(4,4);
//
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));

    }
}

class DataNode {

    int key;
    int value;
    DataNode next;
    DataNode prev;

}


