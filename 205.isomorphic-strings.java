import java.util.*;

/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (37.10%)
 * Likes:    820
 * Dislikes: 236
 * Total Accepted:    217K
 * Total Submissions: 573.4K
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "foo", t = "bar"
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * Note:
 * You may assume both s and t have the same length.
 * 
 */
class Solution {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }

        if (s.equals(t)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            char s_char = s.charAt(i);
            char t_char = t.charAt(i);

            

            Character temp = map.putIfAbsent(s_char, t_char);

            if (temp != null && temp != t_char) {
                return false;
            }

            Character c = getKey(map, t_char);
            if (c != null && c != s_char) {
                return false;
            }
        }

        return true;
    }

    public static Character getKey(Map<Character, Character> map, char value){
        for(char key: map.keySet()){
            if(map.get(key).equals(value)){
                return key;
            }
        }
        return null;
    }
    // public boolean isIsomorphic2(String s, String t) {
    //     String s_list = "";
    //     String t_list = "";


    //     if (s.length() != t.length()) {
    //         return false;
    //     }

    //     if (s.equals(t)) {
    //         return true;
    //     }

    //     for (int i = 0; i < s.length(); i++) {
    //         if (include(s, s.charAt(i)) == i) { // first appearance
    //             s_list += Integer.toString(i);
    //         }
    //         else {
    //             s_list += Integer.toString(include(s, s.charAt(i)));
    //         }

    //         if (include(t, t.charAt(i)) == i) { // first appearance
    //             t_list += Integer.toString(i);
    //         }
    //         else {
    //             t_list += Integer.toString(include(t, t.charAt(i)));
    //         }

    //     }



    //     return s_list.equals(t_list);

    // }

    // public static int include(String s, char c) {
    //     for (int i = 0; i < s.length(); i++) {
    //         if (s.charAt(i) == c) {
    //             return i;
    //         }
    //     }

    //     return -1;
    // }
}


