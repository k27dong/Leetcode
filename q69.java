public class q69 {
    public int mySqrt(int x) {
        long l = 0;
        long r = x;
        
        while (l < r) {
            long mid = l + (r - l) / 2 + 1;
            
            if (mid * mid > x) {
                r = mid - 1;
            }
            else {
                l = mid;
            }
        }
        return (int)l;
    }
}