/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
  public int removeElement(int[] nums, int val) {
    int slow, fast, length;
    slow = fast = length = 0;
    for (; fast < nums.length; fast++) {
      if (nums[fast] != val) {
        nums[slow] = nums[fast];
        length++;
        slow++;
      }
    }
    return length;
  }
}
// @lc code=end

