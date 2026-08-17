class Solution {
    public boolean isPalindrome(String s) {
        int i = 0; 
        int j = s.length() - 1;

        while (i < j) {
            if (!isAlphaNum(s.charAt(i))) i++;
            else if (!isAlphaNum(s.charAt(j))) j--;
            else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static boolean isAlphaNum(char c) {
        if ((c >= 'a' && c<= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) return true;
        return false;
    }
}
