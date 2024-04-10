package com.ask.workout.algo.leetcode3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfMaxElementsInRight {

    public static void main(String[] args) {
        int[] input = {9,1,3,4};
        NumberOfMaxElementsInRight numberOfMaxElementsInRight = new NumberOfMaxElementsInRight();
        print(numberOfMaxElementsInRight.maxElementInRight(input));
    }

    public static void print(int[] nums) {
        Arrays.stream(nums).forEach(num -> System.out.print(num  + "\t"));
        System.out.println();
    }

    public int[] maxElementInRight(int[] nums) {
        PriorityQueue<DataNodes> queue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        for (int index = 0; index < nums.length; index++) {
            DataNodes dataNodes = new DataNodes();
            dataNodes.val = nums[index];
            dataNodes.index = index;
            queue.offer(dataNodes);
        }
        DataNodes[] dataNodesArray = queue.toArray(new DataNodes[0]);
        int[] result = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {

                int currentIndex = getCurrentPosition(nums[index], dataNodesArray);
                int count = 0;

                while (currentIndex < nums.length) {
                    if (dataNodesArray[currentIndex].index > index) {
                        currentIndex = getRightIndex(currentIndex);
                        count++;
                    } else {
                        break;
                    }
                }
            result[index] = count;

        }

        return result;


    }

    public int getCurrentPosition(int val, DataNodes[] dataNodes) {
        int currentIndex = 0;
        while (currentIndex < dataNodes.length) {
            if (val == dataNodes[currentIndex].val) {
                return currentIndex;
            }
            if (val < dataNodes[currentIndex].val) {
                currentIndex = getLeftIndex(currentIndex);
            } else {
                currentIndex = getRightIndex(currentIndex);
            }

        }
        return -1;
    }

    public int getLeftIndex(int index) {
        return 2*index +1;
    }

    public int getRightIndex(int index) {
        return 2*index +2;
    }

    public int getRoot(int index) {
        return (index-1)/2;
    }


}
class DataNodes {
    int val;
    int index;
}
