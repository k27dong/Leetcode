import java.util.HashMap;

/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (52.24%)
 * Likes:    1862
 * Dislikes: 160
 * Total Accepted:    417.2K
 * Total Submissions: 777.8K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            Integer now = map.putIfAbsent(temp, 1);
            int current_size = 1;

            if (now != null) {
                map.put(temp, now+1);
                current_size = now+1;
            }

            if (current_size > nums.length/2) {
                return temp;
            }
        }

        return -1;
    }
}

