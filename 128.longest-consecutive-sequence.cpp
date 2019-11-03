/*
 * @lc app=leetcode id=128 lang=cpp
 *
 * [128] Longest Consecutive Sequence
 */
// @lc code=start
class Solution {
public:
    /**
     * Since the elements are unordered and required O(n), use hash map
     **/
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int, bool> used;

        // establish the map
        for (auto i : nums) {
            used[i] = false;
        }

        // stores the longest consecutive string
        int longest = 0;

        for (auto i : nums) {
            if (used[i]) {
                continue;
            }

            int length = 1;
            used[i] = true;

            // look right
            for (int j = i + 1; used.find(j) != used.end(); ++j) {
                used[j] = true;
                ++length;
            }

            // look left
            for (int j = i - 1; used.find(j) != used.end(); --j) {
                used[j] = true;
                ++length;
            }

            longest = max(longest, length);
        }

        return longest;    
    }
};
// @lc code=end

