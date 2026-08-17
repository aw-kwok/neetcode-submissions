class Solution {
    public int longestConsecutive(int[] nums) {
        int soln = 0;
        HashSet<Integer> hs = new HashSet();
        for(int i : nums) {
            hs.add(i);
        }
        for(Integer i : hs) {
            int num = i;
            if (!hs.contains(num - 1)) {
                int count = 1;
                while (hs.contains(num + 1)) {
                    count++;
                    num++;
                }
                soln = Math.max(soln, count);
            }
        }
        return soln;
    }
}
