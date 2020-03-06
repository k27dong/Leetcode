/*
 * @lc app=leetcode id=334 lang=java
 *
 * [334] Increasing Triplet Subsequence
 */

// @lc code=start
class Solution {
  public boolean increasingTriplet(int[] nums) {
    if (nums.length <= 2) {
      return false;
    }
    
    int a, b, c;
    a = b = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      c = nums[i];
      if (c < a) {
        a = c;
      }
      if (c > a && c < b) {
        b = c;
      } 
      if (c > b) {
        return true;
      }
    }
    return false;
  }
}
// @lc code=end

