import java.util.ArrayList;

public class q3 {
    public static int lengthOfLongestSubstring2 (String s) {
        /* FIX ME */
        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) { 
            return 2;
        }
        int left = 0;
        int right = 0;
        
        ArrayList<Character> a = new ArrayList<>(); // stores the piece of string

        while (right < s.length() - 1) {
            while(true) {
                right++;
                char now = s.charAt(right);
                if(!a.contains(now)) {
                    a.add(now);
                }
                else {
                    // if 'a' contains the new character
                    left = a.indexOf(now) + 1;

                    break;
                }
            }
            // find the index of the repeat char, [?] [now]
        }
        System.out.println("LEFT: "  + left);
        System.out.println("RIHGT: " + right);
        if (s.charAt(left) == s.charAt(right)) {
            return right - left - 1;
        }
        else {
            return right - left;
        }
    }

    public static int lengthOfLongestSubstring3 (String s) {
        /* FIX ME */
        if (s.equals("")) {
            return 0;
        }
        if (s.length() == 0 || s.length() == 1 || s == null || s.equals("   ")) {
            return 1;
        }
        int left = 0;   // left index
        int right = 0;  // right index
        int length = 1;
        
        // increase length -> move horizontally -> increase length -> ... reaches the end
        outerloop:
        while (right <= s.length() - 1) {
            while (valid(s, left, length)) {
                if (left + length >= s.length()) {
                    length++;
                    break outerloop;    // break through the whole process
                }
                right++;
                length++;
            }   
            // at this point, left <-> right is invalid
            // [right] is the index that is repeated
            if (right >= s.length()) {
                break outerloop;
            }
            int temp = s.indexOf(Character.toString(s.charAt(right)));  // the left repeated index [temp]

            // [temp] ... [right] <- 左右重复

            if (temp + length >= s.length()) {
                break outerloop;
            }
            if (right >= s.length() - 2) {
                if (s.length() == 3 && s.charAt(1) == s.charAt(2)) {

                }
                else {
                    length++;
                }
                
                break outerloop;
            }

            left = temp + 1;
            right++;

            while (!valid(s, left, length)) {
                if (left + length >= s.length()) {
                    break outerloop;
                }
                left++;
                right++;
            }
            // find a new valid position with +1 length

        }

        if(s.length() >= 4) {
            if (s.charAt(0) == s.charAt(1) || s.charAt(s.length()-1) == s.charAt(s.length()-2)) {
                length --;
            }
        }

        return length - 1;
    }

    public static boolean valid(String s, int left, int length) {
        // utility function
        // check for any repetitaves for string s, starting from left, for length long
        // assume length is valid (within the range of String s)

        length--;
        String ss = s.substring(left, left + length + 1);
        for (int i = 0; i < ss.length() - 1; i++) {
            String temp = ss.substring(i + 1, ss.length());
            if (temp.indexOf(ss.charAt(i)) != -1) {
                return false;
            }
        }
        return true;
    }

    public static int lengthOfLongestSubstring (String s) {
        /**
         * sliding window
         * String s: [0, s.length()-1]
         * From: [0, 0]
         * To: [x, s.length - 1]
         * 
         * the window is sliding from left to right
         * no character in this window is repeated
         * if cases:
         * 1: if the next char is new, r++
         * 2: if the next char is old, l--
         *    this step is repeated until the next char becomes new
         * 
         * window length is watched continuously, update length if it increases
         */
        int l = 0;  // left cursor
        int r = 0; // right cursor
        int length = 0; // length (returned)
        ArrayList<Character> list = new ArrayList<>();  // all the retrived char is stored here

        while (r < s.length()) {
            if (!list.contains(s.charAt(r))) {
                // the next char is new
                list.add(s.charAt(r));
                r++;
            }
            else {
                // the next char is old
                while (s.charAt(l) != s.charAt(r)) {
                    list.remove(list.indexOf(s.charAt(l)));
                    l++;
                }
                list.remove(list.indexOf(s.charAt(r)));
                l++;
            }
            length = Math.max(length, r - l);
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}