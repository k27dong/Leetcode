public class q58 {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }

        while (s.charAt(s.length()-1) == ' ') {
            s = s.substring(0, s.length()-1);
            if (s.length() == 0) {
                return 0;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return s.length() - i - 1;
            }
        }

        return s.length();
    }
}