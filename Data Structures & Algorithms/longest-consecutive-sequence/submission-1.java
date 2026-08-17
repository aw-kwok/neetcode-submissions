class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
    
        HashSet<Integer> hs = new HashSet();
        for(int i : nums) {
            hs.add(i);
        }

        int soln = 1;

        for(int i=0; i < nums.length; i++) {
            int target = nums[i];
            if (!hs.contains(target - 1)) {
                int length = 1;
                while(hs.contains(target + 1)) {
                    length++;
                    target++;
                }
                soln = Math.max(soln, length);
            }
        }
        return soln;
    }
}
