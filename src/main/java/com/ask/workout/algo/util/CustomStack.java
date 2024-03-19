package com.ask.workout.algo.util;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CustomStack {
    int top = -1;
    int[] data;
    CustomStack() {
        this.data = new int[10];
    }

    CustomStack(int size) {
        this.data = new int[size];
    }

    public int peek() {
        if(top < 0) {
            throw new RuntimeException("Stack is empty");
        }
        return data[top];
    }

    public int pop() {
        if(top < 0) {
            throw new RuntimeException("Stack is empty");
        }
        int removedElement = data[top];
        data[top] = 0;
        top--;
        return removedElement;
    }

    public void push(int val) {
        if(top+1 > data.length) {
            throw new RuntimeException("Exhaused the limit");
        }
        data[++top] = val;
    }

    public void print() {
        IntStream.range(0, top+1).forEach(index -> {
            System.out.print(data[index] + "\t");
        });
        System.out.println();
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();
        customStack.push(2);
        customStack.push(4);
        customStack.print();
        System.out.println(customStack.peek());
        customStack.pop();
        System.out.println(customStack.peek());
    }
}
