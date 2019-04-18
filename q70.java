public class q70 {
    public int climbStairs(int n) {
        // fibonacci sequence
        // a_(n-1) + a_(n) = a_(n+1)

        /**
         * so instead of moving down, move up
         */

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int now = 0, i = 1, j = 2, k = 3;    // starting point: 3
        while (k <= n) {
            now = i + j;    // now: the next value
            i = j;
            j = now;
            k++;
        }
        return now;
    }

    public int climbStairs2(int n) {
        if (n == 1) { 
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}