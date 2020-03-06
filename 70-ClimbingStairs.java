/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
  public int climbStairs(int n) {
    if (n <= 3) {
      return n;
    }
    /**
     * f(2) = 2, f(1) = 1
     * f(n) = f(n-1) + f(n-2), n >= 3
     */
    int i1 = 1;
    int i2 = 2;
    for (int i = 3; i <= n; i++) {
      int temp = i1 + i2;
      i1 = i2;
      i2 = temp;
    }
    return i2;
  }
}
// @lc code=end

