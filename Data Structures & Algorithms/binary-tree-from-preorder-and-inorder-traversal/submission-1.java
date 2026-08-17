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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, inorder, map);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, Map<Integer, Integer> map) {
        if (preorder.length == 0) return null;

        TreeNode node = new TreeNode(preorder[0]);

        int index = map.get(preorder[0]);

        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, 1 + inorderLeft.length);

        int[] inorderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] preorderRight = Arrays.copyOfRange(preorder, preorderLeft.length + 1, preorder.length);

        node.left = buildTree(preorderLeft, inorderLeft);
        node.right = buildTree(preorderRight, inorderRight);

        return node;
    }
}
