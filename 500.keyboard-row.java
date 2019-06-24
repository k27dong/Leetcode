/*
 * @lc app=leetcode id=500 lang=java
 *
 * [500] Keyboard Row
 */
class Solution {
    public String[] findWords(String[] words) {
        String top = "qwertyuiop";
        String mid = "asdfghjkl";
        String bot = "zxcvbnm";

        String[] ans = new String[0];

        for (int i = 0; i < words.length; i++) {
            String now = words[i].toLowerCase();

            boolean temp = check(top, now);
            if (temp) {
                ans = next_array(ans, words[i]);
            }
            else {
                temp = check(mid, now);
                if (temp) {
                   ans = next_array(ans, words[i]);
                }
                else {
                    temp = check(bot, now);
                    if (temp) {
                        ans = next_array(ans, words[i]);
                    }
                }
            }
        }
        return ans;
    }

    public String[] next_array(String[] s, String str) {
        int l = s.length;

        String[] next = new String[l+1];
        for (int i = 0; i < s.length; i++) {
            next[i] = s[i];
        }
        next[next.length-1] = str;
        return next;
    }

    public boolean check(String list, String now) {
        // check if all members in now is also a member in list
        boolean b = true;
        for (int i = 0; i < now.length(); i++) {
            int current = list.indexOf(now.charAt(i));
            if (current == -1) {
                b = false;
                break;
            }
        }
        return b;
    }
}

