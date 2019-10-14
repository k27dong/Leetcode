/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */
class Solution {
    public boolean isHappy(int n) {
        if (n == 0 || n == 1) {
            return true;
        }

        /**
         * All 'unhappy number' ends in a loop of:
         * 4, 16, 37, 58, 89, 145, 42, 20, 4
         */
        
        while ((n = get_result(n)) != 1) {
            if (isUnhappy(n)) return false;
        }

        return true;
    }

    public int get_result (int n) {
        // return the next number
        int sum, length, copy;
        sum = length = 0;
        copy = n;
        while (copy != 0) {
            ++length;
            copy /= 10;
        }

        for (int i = 0; i < length; ++i) {
            int current = n % 10;
            sum += current * current;
            n /= 10;
        }

        return sum;
    }

    public boolean isUnhappy (int n) {
        return n == 4 || n == 16 || n == 37 || n == 58 || n == 89 || n == 145 || n == 42 || n == 20;
    }
}

