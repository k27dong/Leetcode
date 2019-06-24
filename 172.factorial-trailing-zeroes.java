/*
 * @lc app=leetcode id=172 lang=java
 *
 * [172] Factorial Trailing Zeroes
 */
class Solution {
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        if (n > 2147483645) {
            return 536870902;
        }

        int five = 0;
        // count the number of 5's in the list

        for (int i = 5; i <= n; i += 5) {
            five++;
            int now = i/5;

            while(now%5==0 && now != 0) {
                now /= 5;
                five++;
            } 
        }

        return five;
    }
}

