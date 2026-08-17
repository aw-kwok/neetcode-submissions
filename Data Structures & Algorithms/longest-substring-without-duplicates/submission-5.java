class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while(r < s.length()) {
            if(!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
                max = Math.max(max, r - l);
            }
            else {
                set.remove(s.charAt(l));
                l++;
            }
        }
        return max;
    }
}
