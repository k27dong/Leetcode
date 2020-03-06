/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        // push
        stack.push(c);
      }
      if (c == ')' || c == ']' || c == '}') {
        // pop
        if (stack.size() == 0) {
          return false;
        }
        char back = stack.pop();
        if (
          (c == ')' && back != '(') ||
          (c == '}' && back != '{') ||
          (c == ']' && back != '[')
        ) {
          return false; // params dont match
        }
      }
    }
    return stack.size() == 0;
  }
}
// @lc code=end

