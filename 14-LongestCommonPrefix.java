/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    if (strs.length == 1) return strs[0];

    String ans = "";
    char next;

    outerloop: for (int i = 0; i < strs[0].length(); i++) {
      next = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (
          strs[j].length() <= i ||
          strs[j].charAt(i) != next
        ) {
          break outerloop;
        }
      }
      ans += next;
    }

    return ans;
  }
}
// @lc code=end
