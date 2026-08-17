class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t = 0;
        int b = matrix.length - 1;
        int l = -1;
        int r = -1;
        int midRow = -1;
        while (t <= b) {
            midRow = (t + b) / 2;
            if (matrix[midRow][0] <= target && matrix[midRow][matrix[0].length - 1] >= target) {
                l = 0;
                r = matrix[0].length;
                break;
            }
            else if (target < matrix[midRow][0]) b = midRow - 1;
            else t = midRow + 1;
        }
        if (l != -1) {
            while (l <= r) {
                int midCol = (l + r) / 2;
                if (target == matrix[midRow][midCol]) return true;
                else if (target < matrix[midRow][midCol]) r = midCol - 1;
                else l = midCol + 1;
            }
        }
        return false;
    }
}
