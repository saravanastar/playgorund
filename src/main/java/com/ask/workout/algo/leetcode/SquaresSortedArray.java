package com.ask.workout.algo.leetcode;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresSortedArray {

    public static void main(String[] args) throws IOException {
        LocalDate date = LocalDate.of(2015, 12, 12);
        date = date.with(ChronoField.DAY_OF_YEAR, 30);
        out.println(date);
        Object obj = new Double(3);
        Number number = (Number) obj;
        out.println(number);
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("C");
        stringList.add("E");
        stringList.add("D");
        stringList.add(1, "B");
        stringList.set(4, "F");
        out.println(stringList);
        Thread thread = new Thread(SquaresSortedArray::threadRun);
        thread.start();
        Messagable messagable = Message::new;
        messagable.getMessage("Hello");
        messagable.getMessage("World");
        String s = "DoSelectLAb";
        s.substring(1,4);
        out.println(s.charAt(3));
        s.concat("ef");
        out.println(s);
        int a = 1_000;

    }
    {
        out.println("sdf");
    }
    static {
        out.println("static");
    }
    public static void threadRun() {
        out.println("Thread is running");
    }


//    public int[] sortedSquares(int[] nums) {
//        int left = 0;
//        int right = nums.length;
//
//    }
    /**
     * -4,-1,0,3,10
     * left = 0 , right = n;
     * if (sqrt(arr[left]) > sqrt(arr[right]) {
     *     shift(left, right)
     *
     * }
     *
     */
}

interface TestInterface {
    void call();
}

abstract class TestAbstract implements TestInterface {

}

interface Messagable {
    Message getMessage(String msg);
}
class Message {
    Message(String message) {
        out.println(message);
    }
}


