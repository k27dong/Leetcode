/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
  public int lengthOfLastWord(String s) {
    int length = 0;
    int pos = s.length() - 1;
    for (; pos >= 0 && s.charAt(pos) == ' '; pos--) {}
    for (; pos >= 0 && s.charAt(pos) != ' '; pos--, length++) {}
    return length;
  }
}
// @lc code=end

