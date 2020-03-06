/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
  public int myAtoi(String str) {
    if (str.length() == 0) {
      return 0;
    }
    
    // skip leading whitespaces
    int curr = 0;
    int sign = 1;
    long result = 0;
    while (curr < str.length() && str.charAt(curr) == ' ') {
      curr++;
    }

    // all whitespace
    if (curr == str.length()) {
      return 0;
    }

    if (str.charAt(curr) == '-') {
      sign = -1;
      curr++;
    }
    else if (str.charAt(curr) == '+') {
      sign = 1;
      curr++;
    }
    else if (!Character.isDigit(str.charAt(curr))) {
      return 0;
    }

    while (curr < str.length() && Character.isDigit(str.charAt(curr))) {
      result *= 10;
      result += str.charAt(curr) - 48;
      if (result > Integer.MAX_VALUE) {
        return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;  
      }
      curr++;
    }

    return sign * (int)result;
  }
}
// @lc code=end

