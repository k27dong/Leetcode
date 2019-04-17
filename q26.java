public class q26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // slow pointer
        int l = 0;  

        // fast pointer
        for (int i = 0; i < nums.length; i++) {
            if (nums[l] != nums[i]) {
                nums[++l] = nums[i];
            }
        }

        return l + 1;
    }
}