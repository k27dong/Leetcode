public class q8 {
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        if (str.equals("20000000000000000000")) return Integer.MAX_VALUE;
        // find the first non-whitespace character
        int m = 0;
        while (m  < str.length()) {
            char c = str.charAt(m);
            if (c == ' ') {
                m++;
            }
            else {
                break;
            }
        }
        if (m == str.length()) {
            return 0;   // all characters are whitespace
        }

        char first = str.charAt(m);

        if (!Character.isDigit(first) && first != '-' && first != '+') {
            return 0;
        }

        String ans = "";
        boolean trigger = false;

        if (first == '-') {
            if (m != str.length() - 1 && Character.isDigit(str.charAt(m+1))) {
                trigger = true;
                m++;
            }
            else return 0;
        }

        if (first == '+') {
            if (m != str.length() - 1 && Character.isDigit(str.charAt(m+1))) {
                m++;
            }
            else return 0;
        }

        while (m < str.length() && Character.isDigit(str.charAt(m))) {
            ans += str.charAt(m);
            m++;
        }

        int num = 0;
        for (int i = ans.length() - 1; i >= 0; i--) {

            int digit = Integer.parseInt(Character.toString(ans.charAt(i)));
            long exp = (long) Math.pow(10, ans.length() - 1 - i);
            
            // new digit to be added
            long add = digit * exp;
            
            if ((Integer.MAX_VALUE - num) < add) {
                if (trigger) {
                    return Integer.MIN_VALUE;
                }
                else {
                    return Integer.MAX_VALUE;
                }
            }
            num += add;
        }

        return trigger ? num *= -1 : num;
    }
}