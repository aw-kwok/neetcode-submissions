class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        Set<Character> hs = new HashSet<>();
        int max = 1;
        int i = 0;
        int j = 1;
        hs.add(s.charAt(i));
        while (j < s.length()) {
            if (hs.contains(s.charAt(j))) {
                hs.remove(s.charAt(i));
                i++;
            }
            else {
                hs.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);
            }
        }
        return max;
    }
}
