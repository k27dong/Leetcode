/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (m.containsKey(nums[i])) {
        m.put(nums[i], m.get(nums[i]) + 1);
      }
      else {
        m.put(nums[i], 0);
      }
      if (m.get(nums[i]) >= nums.length / 2) {
        return nums[i];
      }
    }
    return -1;
  }
}
// @lc code=end

