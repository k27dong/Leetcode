/**
 * q14
 */
public class q14 {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";

        if (strs.length == 1) {
            return strs[0];
        }

        if (strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {   // i: substring length - 1
            boolean b = true;

            String temp = strs[0].substring(0, i + 1);  // get the prefix to be tested

            innerloop:
            for (int m = 1; m < strs.length; m++) {
                int k = strs[m].indexOf(temp);
                if (k != 0) {
                    b = false;
                    break innerloop;
                }
            }

            if (b) {    // found a common prefix
                if (temp.length() > ans.length()) {
                    ans = temp;
                }
            }
            
        }
        return ans;
    }

    public String longestCommonPrefix2(String[] strs) {
        String ans = "";
        char next;

        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }
        
        outerloop:
        for (int i = 0; i < strs[0].length(); i++) {
            next = strs[0].charAt(i);  // get the newest char
            for (int j = 1; j < strs.length; j++) {
                // check if this char exists in every other string
                if (strs[j].length() <= i || strs[j].charAt(i) != next) {
                    // if i is larger or equal with the string,
                    // or the position contains an illegal char
                    break outerloop;
                }
            }
            ans += next;
        }

        return ans;
    }
    
}