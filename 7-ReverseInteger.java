/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
  public int reverse(int x) {
    long result = 0;
    while (x != 0) {
      result *= 10;
      result += x % 10;
      x /= 10;
    }
    return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;
  }
}
// @lc code=end

