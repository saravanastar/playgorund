package com.ask.workout.fidelity;

public class CodingRound2 {
    public static void main(String[] args) {

    }

    /**
     * s1 = "345" , s2= "15"
     * output = 360
     *
     *  m = s1.length-1
     *  n = s2.length -1
     *  carrier = 0
     *  result= ""
     *  while m>=0 and n>=0:
     *     int s1number= s1[m]
     *     s2_number = s2[n]
     *     sum = s1number + s2_number + carrier
     *     carrier = 0
     *     if sum > 9:
     *          carrier += 1
     *      result.prepend(sum%10)
     *      m -= 1
     *      n -= 1
     *
     *
     *   if m>0:
     *      while m >=0:
     *          result.prepend(carrier + s1[m])
     *          m--;
     *   if(n>0) {
     *       while(n>=0) {
     *           result.prepend(carrier + s2[n]);
     *           n--;
     *       }
     *   }
     *   return result;
     *
     * O(n)
     * 0(n+1)
     */

}
