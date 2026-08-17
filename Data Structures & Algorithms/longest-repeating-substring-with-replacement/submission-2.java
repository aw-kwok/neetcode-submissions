class Solution {
    public int characterReplacement(String s, int k) {
        int soln = 0;
        int l = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(freq[s.charAt(r) - 'A'], maxFreq);

            while(r - l - maxFreq >= k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            soln = Math.max(soln, r - l + 1);
        }
        return soln;
    } 
}
