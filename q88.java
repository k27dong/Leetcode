public class q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            // do nothing
        }
        else if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        }
        else {
            int p, q, i;   // p -> 1, q -> 2,  i -> ans
            p = q = i = 0;

            int sum = m + n;    // total number of element to be sorted

            int[] ans = new int[sum];

            while (p + q < sum) {
                ans[i] = Math.min(nums1[p], nums2[q]);

                if (nums1[p] <= nums2[q]) {
                    p++;
                }
                else {
                    q++;
                }
                i++;

                if (p == m) {
                    // all nums1 are done
                    for (int j = i; j < ans.length; j++) {
                        ans[j] = nums2[q];
                        q++;
                    }
                    break;
                }
                if (q == n) {
                    // all nums2 are done
                    for (int j = i; j < ans.length; j++) {
                        ans[j] = nums1[p];
                        p++;
                    }
                    break;
                }
            }

            for (int f = 0; f < ans.length; f++) {
                nums1[f] = ans[f];
            }
        }
    }
}