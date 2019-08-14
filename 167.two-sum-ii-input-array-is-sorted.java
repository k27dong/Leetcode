/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (50.00%)
 * Likes:    1006
 * Dislikes: 418
 * Total Accepted:    273K
 * Total Submissions: 535.4K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 * 
 * Note:
 * 
 * 
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may
 * not use the same element twice.
 * 
 * 
 * Example:
 * 
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * 
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // find right

        int r = numbers.length - 1;
        while (numbers[r] > target) {
            r--;    // find the last possible index
        }

        int l = 0;

        if (r == 1) {
            return new int[] {l+1, r+1};
        }
        
        while (true) {
            int goal = target - numbers[r]; // what numbers[l] need to be
            for (int i = l; i < r; i++) {
                if (numbers[i] == goal) {
                    return new int[] {i+1, r};
                }
            }

            // no match, iterate again
            r--;
        }
    }
}

