/*
 * @lc app=leetcode id=500 lang=java
 *
 * [500] Keyboard Row
 */

// @lc code=start
class Solution {
  public String[] findWords(String[] words) {
    List<String> s = new ArrayList<String>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (single_row(word)) {
        s.add(word);
      }
    }
    String[] arr = new String[s.size()];
    arr = s.toArray(arr);
    return arr;
  }

  public boolean single_row(String str) {
    String top = "qwertyuiop";  // 1
    String mid = "asdfghjkl";   // 2
    String bot = "zxcvbnm";     // 3

    int status = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      int new_status = 0;
      if (top.indexOf(c) != -1) {
        new_status = 1;
      }
      else if (mid.indexOf(c) != -1) {
        new_status = 2;
      }
      else if (bot.indexOf(c) != -1) {
        new_status = 3;
      }

      if (
        new_status == 1 ||
        new_status == 2 ||
        new_status == 3
      ) {
        if (status == 0) {
          status = new_status;
        }
        else {
          if (status != new_status) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
// @lc code=end

