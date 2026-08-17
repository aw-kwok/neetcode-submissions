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
        if (preorder.length == 0) return null;

        TreeNode node = new TreeNode(preorder[0]);

        int index = -1;
        for(int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                index = i;
                break;
            }
        }

        System.out.println(index);

        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, 1 + inorderLeft.length);

        int[] inorderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] preorderRight = Arrays.copyOfRange(preorder, preorderLeft.length + 1, preorder.length);

        node.left = buildTree(preorderLeft, inorderLeft);
        node.right = buildTree(preorderRight, inorderRight);

        return node;
    }
}
