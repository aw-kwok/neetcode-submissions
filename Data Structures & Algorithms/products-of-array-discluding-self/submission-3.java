class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];
        pref[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
        }
        suff[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suff[i] = nums[i + 1] * suff[i + 1];
        }
        
        int[] soln = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            soln[i] = pref[i] * suff[i];
        }
        return soln;
    }
}  
