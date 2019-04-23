/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double half = myPow(x, n/2);

        if (n % 2 == 0) {
            // 如果是偶数，乘以自身 (2n)
            // 2 = 1 * 1
            return half * half;
        }

        if (n > 0) {
            // 如果是奇数，乘以自身之后再加一
            // 5 = 2 * 2 + 1
            return half * half * x;
        }

        return half * half / x;
    }
}

