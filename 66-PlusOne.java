/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] == 9) {
        digits[i] = 0;
      }
      else {
        digits[i]++;
        break;
      }
    }
    if (digits[0] == 0) {
      int[] ans = new int[digits.length + 1];
      ans[0] = 1;
      return ans;
    }
    else return digits;
  }
}
// @lc code=end

