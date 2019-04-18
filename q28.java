public class q28 {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        else {
            return haystack.indexOf(needle);
        }
    }
}