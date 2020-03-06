/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int temp = x;
    int result = 0;
    while (temp != 0) {
      result *= 10;
      result += temp % 10;
      temp /= 10;
    }
    return x == result;
  }
}
// @lc code=end

