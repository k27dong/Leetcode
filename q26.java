import java.util.Arrays;

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

    public static int remove(int nums[]) {
        Arrays.sort(nums);
        int temp[] = {};
        int answer = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                // do nothing
            }
            else {
                answer++;
                add(temp, nums[i-1]);
            }
        }
        nums = temp;
        return answer;
    }

    public static int[] add(int[] nums, int n) {
        int[] now = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            now[i] = nums[i];
        }
        now[now.length - 1] = n;
        return now;
    }

    public static void print(int[] data) {
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " | ");
        }
        System.out.println();
    }
}