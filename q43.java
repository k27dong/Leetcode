public class q43 {
    /* long division */
    
    public String multiply(String num1, String num2) {
        if (num1.length() + num2.length() < 20) {
            return Long.toString(Long.parseLong(num1) * Long.parseLong(num2));
        }
        
        if (all_zero(num1) || all_zero(num2)) {
            return "0";
        }

        int trim = 0;
        // trim 0 from the back of both string

        while(num1.charAt(num1.length()-1) == '0') {
            num1 = num1.substring(0, num1.length()-1);
            trim++;
        }
        while(num2.charAt(num2.length()-1) == '0') {
            num2 = num2.substring(0, num2.length()-1);
            trim++;
        }
        

        // make sure num2 is longer than num1
        if (num2.length() < num1.length()) {
            // swap
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int[] ans = new int[int_multi(num2, Integer.parseInt(Character.toString(num1.charAt(num1.length()-1)))).length()-1];
        for (int x : ans) {
            x = 0;
        }

        for (int i = num1.length() - 1; i >= 0; i--) {
            String now = int_multi(num2, Integer.parseInt(Character.toString(num1.charAt(i))));

            // shifting depends on ?
            
            
            if (i == num1.length()-1) {
                ans = shift(ans);
                // do nothing
            }
            else {
                int last_length  = int_multi(num2, Integer.parseInt(Character.toString(num1.charAt(i+1)))).length();
                if (last_length == now.length()) {
                    ans = shift(ans);
                }
                else if (last_length < now.length()) {
                    ans = shift(ans);
                    ans = shift(ans);
                }
                else {
                    // do nothing
                }
            }
            

            for (int j = 0; j < now.length(); j++) {
                ans[j] += Integer.parseInt(Character.toString(now.charAt(j)));
            }
            
        }

        int carryon = 0;
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] += carryon;
            carryon = 0;
            while (ans[i] >= 10) {
                ans[i] -= 10;
                carryon++;
            }
        }
        
        String ans_str = "";
        if (carryon != 0) {
            ans_str += Integer.toString(carryon);
        }
        for (int i = 0; i < ans.length; i++) {
            ans_str += Integer.toString(ans[i]);
        }

        for (int i = 0; i < trim; i++) {
            ans_str += "0";
        }


        return ans_str;
    }

    public boolean all_zero(String n) {
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    public String int_multi(String s, int n) {
        int carryon = 0;
        String ans = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            int now = Integer.parseInt(Character.toString(s.charAt(i)));    // the number to be multiplied
            now *= n;
            now += carryon;
            carryon = 0;
            while (now >= 10) {
                now -= 10;
                carryon++;
            }
            ans = Integer.toString(now) + ans;
        }

        if (carryon != 0) {
            ans = Integer.toString(carryon) + ans;
        }

        return ans;
    }

    public int[] shift(int[] n) {
        int[] ans = new int[n.length + 1];
        for (int i = 0; i < n.length; i++) {
            ans[i+1] = n[i];
        }
        return ans;
    }

    public void printarray(int[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " | ");
        }
    }

    /***********/

    public String multiply2(String num1, String num2) {
        // addition as in multiplication

        // make sure num1 is longer than num2

        if (num1.length() < num2.length()) {
            // swap
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        
        String counter = "0";
        String ans = "0";

        while (!counter.equals(num2)) {
            ans = addition(ans, num1);
            counter = addOne(counter);
        }

        return ans;
    }

    public String addition(String s, String b) {
        boolean lever = false;
        String ans = "";

        // make sure b is longer than s
        if (b.length() < s.length()) {
            // swap
            String temp = b;
            b = s;
            s = b;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            int s_now = Integer.parseInt(Character.toString(s.charAt(i)));
            int b_now = Integer.parseInt(Character.toString(b.charAt(i)));

            int sum_now = s_now + b_now;
            sum_now += lever ? 1 : 0;
            lever = false;
            
            if (sum_now >= 10) {
                sum_now -= 10;
                lever = true;
            }

            ans = Integer.toString(sum_now) + ans;
        }

        String forehead = b.substring(0, b.length() - s.length());
        if (lever) {
            forehead = addOne(forehead);
        }

        return  (forehead + ans);
    }

    public String timesTwo(String s) {
        boolean lever = false;
        String ans = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            int now = Integer.parseInt(Character.toString(s.charAt(i)));
            
            now *= 2;
            now += lever ? 1 : 0; // if lever is on, add 1
            lever = false;

            if (now >= 10) {
                now -= 10;
                lever = true;
            }

            ans = Integer.toString(now) + ans;
        }
        // at the end

        if (lever) {
            ans = "1" + ans;
        }

        return ans;
    }

    public String addOne(String s) {
        boolean lever = false;
        String ans = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            int now = Integer.parseInt(Character.toString(s.charAt(i)));
            
            now ++;
            now += lever ? 1 : 0; // if lever is on, add 1
            lever = false;

            if (now >= 10) {
                now -= 10;
                lever = true;
            }

            ans = Integer.toString(now) + ans;
        }
        // at the end

        if (lever) {
            ans = "1" + ans;
        }

        return ans;
    }
}