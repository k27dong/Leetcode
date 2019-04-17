/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (40.93%)
 * Total Accepted:    373.1K
 * Total Submissions: 911.2K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * 
 */
class q66 {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length-1] != 9) {
            digits[digits.length-1]++;
            return digits;
        }
        
        // last digit is 9
        int read = digits.length - 1;
        while (digits[read] == 9) {
            read--;
            if (read < 0) {
                int[] next = new int[digits.length+1];
                next[0] = 1;
                for (int j = 1; j < next.length; j++) {
                    next[j] = 0;
                }
                return next;
            }
        }

        digits[read]++;
        for (int i = read+1; i < digits.length; i++) {
            digits[i] = 0;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] test = {9};
        q66 q = new q66();

        test = q.plusOne(test);
        for (int x :  test) {
            System.out.println(x);
        }
    }
}

