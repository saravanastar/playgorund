package com.ask.workout.algo;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinHeap {
    int[] heapStore;
    int currentIndex = 0;
    public MinHeap(int size) {
        heapStore = new int[size];
    }

    public MinHeap() {
        heapStore = new int[10];
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(20);
        minHeap.insert(40);
        minHeap.insert(60);
        minHeap.insert(2);
        minHeap.insert(4);
        minHeap.insert(100);
        minHeap.insert(1);
        minHeap.print();

    }

    private void print() {
        IntStream.range(0, currentIndex).forEach(index -> {
            System.out.println(heapStore[index]);
        });
    }

    private int getParent(int index) {
        return index / 2;
    }

    private int getLeft(int index) {
        return 2 * index;
    }

    private int getRight(int index) {
        return 2 * index + 1;
    }

    private boolean insert(int input) {
        if (currentIndex+1 > heapStore.length) {
            return false;
        }
        if (currentIndex == 0) {
            heapStore[currentIndex] = input;
            currentIndex++;
        } else {

        }
        return true;
    }

    private void heapify(int index) {
        int currentIndex = index;
        while (currentIndex > 0) {
            int parentIndex = getParent(currentIndex);
            if (heapStore[currentIndex] < heapStore[parentIndex]) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
                continue;
            }
            break;
        }
    }

    private void swap(int index1, int index2) {
        int temp = heapStore[index2];
        heapStore[index2] = heapStore[index1];
        heapStore[index1] = temp;
    }
}
