/* Single Number */

public class q136 {
    public static int singleNumber1(int[] nums) {
        int result = 0;
        for (int x : nums) {
            result ^= x;
        }
        return result;
    }

    public static void main(String[] args) {
        int test[] = {1, 2, 3 ,2 ,1};
        System.out.println(singleNumber1(test));
    }
}