/*
 * @lc app=leetcode id=80 lang=cpp
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() <= 2) {
            return nums.size();
        }

        int pointer, i;
        pointer = i = 2;

        for (i; i < nums.size(); ++i) {
            if (nums[i] != nums[pointer - 2]) {
                nums[pointer++] = nums[i];
            }
        }

        return pointer;
    }
};
// @lc code=end

