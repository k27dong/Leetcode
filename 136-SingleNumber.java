/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int x : nums) {
        result ^= x;
    }
    return result;
  }
}
// @lc code=end

