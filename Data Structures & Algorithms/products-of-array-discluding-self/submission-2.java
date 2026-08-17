class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] soln = new int[nums.length];


        // prefix [1, 1, 2, 8]
        // suffix [48, 24, 6, 1]
        // each entry is just pref[n - 1] * suff[n + 1];

        if (nums.length == 0) return new int[0];

        prefix[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < nums.length; i++) {
            soln[i] = prefix[i] * suffix[i];
        }

        return soln;
    }
}  
