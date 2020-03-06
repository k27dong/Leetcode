/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
  public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int result = Integer.MIN_VALUE;
    int f_n = -1; // 以第n个数为结尾的子序列的最大和
    for (int i = 0; i < nums.length; i++) {
      f_n = Math.max(f_n + nums[i], nums[i]);
      result = Math.max(f_n, result);
    }
    return result;
  }
}
// @lc code=end

