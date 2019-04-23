/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;

        while (r > l) {
            ans = Math.max(ans, Math.min(height[r], height[l]) * (r - l));  // find the new area
            if (height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }
        }

        return ans;
    }
}

