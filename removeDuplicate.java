import java.util.Arrays;

public class removeDuplicate {
    
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