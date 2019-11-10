/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;
        vector<int> result;
        int i;
        
        for (i = 0; i < nums.size(); ++i) {
            map[nums[i]] = i;
        }

        for (i = 0; i < nums.size(); ++i) {
            const int gap = target - nums[i]; // this is what we're trying to find
            if (map.find(gap) != map.end() && map[gap] > i) {
                result.push_back(i);
                result.push_back(map[gap]);
                break;
            }
        }

        return result;
    }
};
// @lc code=end

