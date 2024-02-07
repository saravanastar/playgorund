package com.ask.workout.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    static final Character DELIMITER = '#';

    public static void main(String[] args) {
        EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();
        String encodedString = encodeAndDecodeStrings.encode(List.of("Hello", "World"));
        encodeAndDecodeStrings.decode(encodedString).forEach(System.out::println);

        encodedString = encodeAndDecodeStrings.encode(List.of("Hello111111", "Worldsfsdfsdf#$"));
        encodeAndDecodeStrings.decode(encodedString).forEach(System.out::println);
    }

    public String encode(List<String> input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String data: input
             ) {
            stringBuilder.append(data.length()).append(DELIMITER).append(data);
        }
        return stringBuilder.toString();
    }

    // 5#Hello5#World
    public List<String> decode(String input) {
        List<String> output = new ArrayList<>();
        if (input==null || input.isEmpty()) return output;
        char[] inputArray = input.toCharArray();

        for (int index = 0; index < inputArray.length; index++) {

            StringBuilder stringBuilder = new StringBuilder();
            while (inputArray[index] != DELIMITER) {

                stringBuilder.append(inputArray[index]);
                index++;
            }
            index++;
            int lengthOfString = Integer.parseInt(stringBuilder.toString());
            int totalLength = index + lengthOfString;
            stringBuilder = new StringBuilder();
            while (index < totalLength) {
                stringBuilder.append(inputArray[index++]);
            }
            index--;
            output.add(stringBuilder.toString());
        }
        return output;

    }
}
