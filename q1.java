/**
 *  twoSum
 */
public class q1{

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int x[] = {i, j};
                    return x;
                }
            }
        }
        int y[] = {-1, -1};
        return y;
    }

    public static int[] twoSum_2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        int x[] = {i, j};
                        return x;
                    }
                }
            }
        }
        int y[] = {-1, -1};
        return y;
    }
}