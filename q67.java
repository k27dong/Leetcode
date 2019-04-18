/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (38.50%)
 * Total Accepted:    289.9K
 * Total Submissions: 752.1K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */
class q67 {
    public String addBinary(String a, String b) {
        int a_ = Integer.parseInt(a);
        int b_ = Integer.parseInt(b);

        int sum = a_ + b_;
        
        return Integer.toBinaryString((to_decimal(Integer.toString(sum))));
    }
// FUUUUUUUUUCK
    public static int to_decimal(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.length() - 1 - i;
            sum += Character.getNumericValue(s.charAt(i)) * Math.pow(2, index);
        }
        return sum;
    }

    public static void main(String[] args) {
        String a = "";
        System.out.println(to_decimal(a));
    }
}

