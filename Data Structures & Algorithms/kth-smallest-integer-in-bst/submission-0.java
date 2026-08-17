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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> traversed = new ArrayList<>();
        inOrderTraversal(root, traversed);
        return traversed.get(k - 1);
    }

    public void inOrderTraversal(TreeNode root, List<Integer> traversed) {
        if (root == null) return;
        inOrderTraversal(root.left, traversed);
        traversed.add(root.val);
        inOrderTraversal(root.right, traversed);
    }
}
