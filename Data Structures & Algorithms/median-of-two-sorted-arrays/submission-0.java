class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A;
        int[] B;
        if (nums1.length <= nums2.length) {
            A = nums1;
            B = nums2;
        }
        else {
            A = nums2;
            B = nums1;
        }
        int l = 0;
        int r = A.length - 1;
        int total = nums1.length + nums2.length;
        int half = total / 2;
        while (true) {
            int i = (int) Math.floor((double) (l + r) / 2); // right of arr A left partition
            int j = half - i - 2; // right of arr B left partition
            
            int aRofL = i >= 0 ? A[i] : -Integer.MAX_VALUE;
            int aLofR = i + 1 < A.length ? A[i + 1] : Integer.MAX_VALUE;
            int bRofL = j >= 0 ? B[j] : -Integer.MAX_VALUE;
            int bLofR = j + 1 < B.length ? B[j + 1] : Integer.MAX_VALUE;

            System.out.println(aRofL);
            System.out.println(aLofR);
            System.out.println(bRofL);
            System.out.println(bLofR);

            if (aRofL <= bLofR && bRofL <= aLofR) {
                if (total % 2 == 0) {
                    return (double) (Math.max(aRofL, bRofL) + Math.min(aLofR, bLofR)) / 2;
                }
                else return Math.min(aLofR, bLofR);
            }
            else if (aRofL > bLofR) r = i - 1;
            else l = i + 1;
        }
    }
}
