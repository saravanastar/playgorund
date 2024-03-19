package com.ask.workout.algo.util;

public class CustomQueue {
    private int front = -1;
    private int rear = -1;

    int[] data;

    CustomQueue() {
       data = new int[5];
    }

    CustomQueue(int size) {
        data = new int[size];
    }

    public int size() {
        if(front == -1 || rear == -1) {
            return 0;
        }
        return rear - front + 1;
    }

    public boolean isEmpty() {
        return front == -1 || rear == -1;
    }

    public boolean enqueue(int val) {
        if (((rear + 1) % data.length) == front) {
            throw new RuntimeException("Out of size");
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
            data[rear] = val;
        } else {
            rear = ((rear + 1) % data.length);
            data[rear] = val;
        }
        return true;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("No Element to Dequeue");
        }
            if (front == rear) {
                int val = data[front];
                front = -1;
                rear = -1;
                return val;
            } else {
                int val = data[front];
                data[front] = 0;
                front = ((front + 1) % data.length);
                return val;
            }
    }

    public void print() {
        if (rear == -1) {
            System.out.println("No Element to print");
        }
        if (front < rear) {
            for (int index = front; index < rear; index++) {
                System.out.println(data[index]);
            }
        } else{
            for (int index = front; index < data.length; index++) {
                System.out.println(data[index]);
            }

            for (int index = 0; index <= rear; index++) {
                System.out.println(data[index]);
            }
        }
    }

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(2);
        System.out.println(queue.dequeue());
        queue.enqueue(3);
        queue.print();
    }
}
