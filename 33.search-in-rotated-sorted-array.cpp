/*
 * @lc app=leetcode id=33 lang=cpp
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
public:
    int search(vector<int>& nums, int target) {
        // binary search
        // time: O(log n)
        int l = 0, r = nums.size();

        while (l != r) {
            const int mid = l + (r - l) / 2; // mid point
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r-1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return -1;
    }
};
// @lc code=end

