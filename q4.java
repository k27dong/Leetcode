import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q4 {
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        double median = 0;
        List<Integer> all = new ArrayList<Integer>();

        for (int x : nums1) {
            all.add(x);
        }

        for (int x : nums2) {
            all.add(x);
        }

        int[] now = all.stream().mapToInt(i -> i).toArray();
        
        Arrays.sort(now);

        if (now.length % 2 == 1) {
            int m = (now.length - 1) / 2;
            median = now[m];
        }
        else {
            int m = (now.length / 2);
            median = now[m] + now[m-1];
            median /= 2;
        }
        return median;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int all[] = new int[nums1.length + nums2.length];
        double result = 0;
        int index = 0;

        for (int i = 0; i < nums1.length; i++) {
            all[index] = nums1[i];
            index++;
        }
        for (int i = 0; i < nums2.length; i++) {
            all[index] = nums2[i];
            index++;
        }

        Arrays.sort(all);
        double mid = (index)/2;
        
        if (index %2 == 0) {
            result = all[(int)mid] + all[(int)mid-1];
            result = result/2;
        } else {
            result = all[(int)mid];
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 3};
        int[] nums2 = {2, 1};
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }
}