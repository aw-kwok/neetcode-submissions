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
    public boolean isValidBST(TreeNode root) {
        List<Integer> traversed = new ArrayList<>();
        inOrderTraversal(root, traversed);
        for(int i = 1; i < traversed.size(); i++) {
            if (traversed.get(i) <= traversed.get(i - 1)) return false;
        }
        return true;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> traversed) {
        if (root == null) return;
        inOrderTraversal(root.left, traversed);
        traversed.add(root.val);
        inOrderTraversal(root.right, traversed);
    }
}
