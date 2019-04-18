import java.util.Stack;

public class q20 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (bracket_test(s.charAt(i)) == -1) {
                st.push(s.charAt(i));
            }
            if (bracket_test(s.charAt(i)) == 1) {
                if (st.isEmpty()) return false;
                char now = st.pop();
                if (s.charAt(i) == ')' && now != '(') {
                    return false;
                }
                if (s.charAt(i) == '}' && now != '{') {
                    return false;
                }
                if (s.charAt(i) == ']' && now != '[') {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static int bracket_test(char c) {
        if (c == '{' || c == '[' || c == '(') {
            return -1;
        }

        if (c == '}' || c == ']' || c == ')') {
            return 1;
        }

        else return 0;
    }
}