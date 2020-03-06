/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
  public int trap(int[] height) {
    if (height.length <= 2) {
      return 0;
    }
    // find the index of the max height
    int lwater, rwater, max_height;
    max_height = 0;
    for (int i = 0; i < height.length; i++) {
      if (height[i] > height[max_height]) {
        max_height = i;
      }
    }
    lwater = collect_water(height, 0, max_height);
    rwater = collect_water(height, height.length - 1, max_height);
    return lwater + rwater;
  }

  public int collect_water(int[] height, int lindex, int rindex) {
    // rindex is the max height in the array
    int water, l_height, r_height, count;
    water = l_height = r_height = count = 0;
    for (int i = lindex; count < Math.abs(rindex - lindex);) {
      r_height = height[i];
      if (r_height > l_height) {
        l_height = r_height;
      }
      else {
        water += l_height - r_height;
      }
      i = rindex > lindex ? i + 1 : i - 1;
      count++;
    }
    return water;
  }
}
// @lc code=end

