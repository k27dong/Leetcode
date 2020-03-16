/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
class Solution {
  public int titleToNumber(String s) {
    char[] char_arr = s.toCharArray();
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      ans = ans * 26 + (char_arr[i] - 64);
    }
    return ans;
  }
}
// @lc code=end

