/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (30.83%)
 * Likes:    601
 * Dislikes: 1769
 * Total Accepted:    365.9K
 * Total Submissions: 1.2M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "race a car"
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            // empty string
            return true;
        }

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char lchar, rchar;
            lchar = s.charAt(l);
            rchar = s.charAt(r);
            while (!(isValid(lchar) && isValid(rchar)) && l < r) {
                if (!isValid(lchar)) lchar = s.charAt(++l);
                if (!isValid(rchar)) rchar = s.charAt(--r);
            }

            if (l >= r) {
                return true;
            }
            lchar = Character.toLowerCase(lchar);
            rchar = Character.toLowerCase(rchar);

            // now we get the next pair of letter
            if (lchar != rchar) {
                return false;
            }
            ++l; --r;
        }
        

        return true;
    }

    public boolean isValid(char c) {
        // see if this char is a letter or a number, else return false
        return Character.isDigit(c) || Character.isLetter(c);
    }
}

