/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1]; // for "pass by reference" (though java passes address by value)
        bfs(root, res);
        return res[0];
        
    }

    // returns height of tree
    private int bfs(TreeNode root, int[] res) {
        if (root == null) return 0;
        int left = bfs(root.left, res);
        int right = bfs(root.right, res);
        res[0] = Math.max(res[0], left + right);
        return Math.max(left, right) + 1;
    }
}
