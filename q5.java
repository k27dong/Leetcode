import java.util.ArrayList;
import java.util.Arrays;

public class q5 {
    public String longestPalindrome1(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        if (isSame(s)) {
            return s;
        }

        String s_f = flip(s);
        
        
        return "";
    }

    /* 2nd approach */
    public static String longestPalindrome2(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        if (isSame(s)) {
            return s;
        }
        /* brute force */
        String longest = "";
        for (int i = s.length()-1; i >=0; i--) {
            for (int j = i; j < s.length(); j++) {
                String now = s.substring(j-i, j+1);
                if (isPalindrome(now) && now.length() >= longest.length()) {
                    longest = now;
                    System.out.println(now);
                }
            }
        }
        return longest;
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        while (i < s.length() - i - 1) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static boolean isSame(String s) {
        char c = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (c != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static String flip(String s) {
        String ans = "";
        for (int i = s.length()-1; i >= 0; i--) {
            ans += s.charAt(i);
        }
        return ans;
    }
    /* end of 2nd approach */


    /*** final ver ***/
    private static int maxLength = 0;
    private static int start = 0;

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            i = expandCenter(s, i);
        }

        return s.substring(start, start + maxLength);
    }
    
    public static int expandCenter(String s, int k) {
        int i = k - 1;
        int j = k;

        while (j < s.length() - 1 && s.charAt(j) == s.charAt(j+1)) {
            j++;
        }

        int nextCenter = j++;

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        if (j - i - 1 > maxLength) {
            maxLength = j - i - 1;
            start = i + 1;
        }

        return nextCenter;
    }


    public static void main(String[] args) {
        String s = "abcbaqwerrewq";
        System.out.println(longestPalindrome(s));
    }
}