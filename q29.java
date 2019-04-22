public class q29 {
    public int divide(int dividend, int divisor) { 
        // some shortcuts
        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        if (dividend == divisor) return 1;
        if (divisor == -1) {
            return (dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend;
        }
        if (divisor == Integer.MAX_VALUE) {
            return (dividend == Integer.MIN_VALUE) ? -1 : 0;
        }

        // check if the two have the same sign
        boolean negative = (dividend ^ divisor) < 0;

        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);

        int result = 0;
        
        for (int i = 31; i >= 0; i--) {

            if ((t >> i) >= d) {
                result += 1 << i;
                t -= d << i;
            }
        }

        // return based on their signs' difference
        return negative ? -result : result;
    }
    
    public int divide2(int dividend, int divisor) {
        boolean l = false, r = false;

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return 2147483647;
            }
            if (divisor == 1) {
                return -2147483648;
            }
        }


        if (dividend < 0) {
            dividend *= -1;
            l = true;
        }
        if (divisor < 0) {
            divisor *= -1;
            r = true;
        }

        // now both number are positive
        int ans = 0;

        while (dividend >= divisor) {
            dividend -= divisor;
            ans++;
        }

        if ((l && !r) || (!l && r)) {
            return -1 * ans;
        }
        else {
            return  ans;
        }
    }
}