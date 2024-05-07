package com.ask.workout.algo.leetcode3;

import java.util.List;
import java.util.Stack;

public class KeysAndRooms {

    public static void main(String[] args) {
        KeysAndRooms keysAndRooms = new KeysAndRooms();
        List<List<Integer>> rooms1= List.of(List.of(1), List.of(2), List.of(3), List.of());
        List<List<Integer>> rooms2= List.of(List.of(1,3), List.of(3,0,1), List.of(2), List.of(0));
        System.out.println(keysAndRooms.canVisitAllRooms(rooms1));
        System.out.println(keysAndRooms.canVisitAllRooms(rooms2));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Stack<Integer> holder = new Stack<>();
        int index = 0;
        List<Integer> indexList = rooms.get(0);
        for (Integer val: indexList) {
            if (!visited[val]) {
                visited[val] = true;
            }
            holder.push(val);
        }
        while(!holder.isEmpty()) {
                int element = holder.pop();
            indexList = rooms.get(element);
            for (Integer val: indexList) {
                if (!visited[val]) {
                    visited[val] = true;
                    holder.push(val);
                }

            }
        }

        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }

        return true;
    }
}
