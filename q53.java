public class q53 {
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) { // begin index
            for (int j = i; j < nums.length; j++) { // end index
                int sum = nums[i];
                for (int k = i + 1; k <= j; k++) {
                    sum += nums[k];
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}