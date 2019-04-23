/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

class Solution {
    public int divide(int dividend, int divisor) { 
        // some shortcuts
        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        if (dividend == divisor) return 1;
        if (divisor == -1) {
            return (dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend;
        }
        if (divisor == Integer.MAX_VALUE) {
            return (dividend == Integer.MIN_VALUE) ? -1 : 0;
        }

        // check if the two have the same sign
        boolean negative = (dividend ^ divisor) < 0;

        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);

        int result = 0;
        
        for (int i = 31; i >= 0; i--) {

            if ((t >> i) >= d) {    // t/2^i >= d
                result += 1 << i;   // + 2^n
                t -= d << i;
            }
        }

        // return based on their signs' difference
        return negative ? -result : result;
    }
}

