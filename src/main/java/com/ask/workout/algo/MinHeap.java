package com.ask.workout.algo;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinHeap {
    int[] heapStore;
    int currentIndex = -1;
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
        System.out.println();
        minHeap.remove();
        minHeap.print();
        System.out.println();
        minHeap.remove();
        minHeap.print();
        System.out.println();
        minHeap.remove();
        minHeap.print();

    }

    private void print() {
        IntStream.range(0, currentIndex+1).forEach(index -> {
            System.out.println(heapStore[index]);
        });
    }

    private int getParent(int index) {
        return (index-1) / 2;
    }

    private int getLeft(int index) {
        return 2 * index + 1;
    }

    private int getRight(int index) {
        return 2 * index + 2;
    }

    private boolean insert(int input) {
        if (currentIndex+1 > heapStore.length) {
            return false;
        }
        heapStore[++currentIndex] = input;
        heapify(currentIndex);
        return true;
    }

    private boolean remove() {
        if (currentIndex == 0) {
            return false;
        }
        heapStore[0] = heapStore[currentIndex];
        heapStore[currentIndex] = 0;
        currentIndex = currentIndex - 1;
        heapifyRemove(0);
        return true;
    }

    private void heapifyRemove(int index) {
        if (index < currentIndex) {
            int smallestIndex = index;
            int leftIndex = getLeft(smallestIndex);
            int rightIndex = getRight(smallestIndex);
            if (leftIndex<= currentIndex && heapStore[leftIndex] < heapStore[smallestIndex]) {
                smallestIndex = leftIndex;
            }
            if (rightIndex<= currentIndex && heapStore[rightIndex] < heapStore[smallestIndex]) {
                smallestIndex = rightIndex;
            }
            if (smallestIndex != index) {
                int temp = heapStore[smallestIndex];
                heapStore[smallestIndex] = heapStore[index];
                heapStore[index] = temp;
                heapifyRemove(smallestIndex);
            }
        }
    }

    private void heapify(int index) {
        int currentIndex = index;
        while (currentIndex > 0) {
            int parentIndex = getParent(currentIndex);
            if (parentIndex >= 0 && heapStore[currentIndex] < heapStore[parentIndex]) {
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
