class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();

        for (int i : nums) {
            hs.add(i);
        }

        int soln = 0;
        for (Integer i : hs) {
            int curr = i;
            int count = 0;
            if (hs.contains(i - 1)) continue;
            while (hs.contains(curr)) {
                count++;
                curr++;
            }
            soln = Math.max(count, soln);
        }
        return soln;
    }
}
