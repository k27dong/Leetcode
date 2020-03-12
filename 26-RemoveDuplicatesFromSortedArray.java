/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 1) return nums.length;
    int ans, now, prev;
    ans = 1;
    prev = nums[0];
    for (int i = 1; i < nums.length; i++) {
      now = nums[i];
      if (now != prev) {
        nums[ans] = now;
        ans++;
      }
      prev = now;
    }
    return ans;
  }
}
// @lc code=end

