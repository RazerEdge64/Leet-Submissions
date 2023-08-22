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
    public boolean isBalanced(TreeNode root) {
        int[] diameter = new int[2];

        return height(root, diameter) != -1;
    }

    private static int height(TreeNode root, int[] diameter) {
        if(root == null) return 0;

        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh);
        diameter[1] = Math.max(diameter[1], rh);

        if(lh == -1 || rh ==-1 || Math.abs(lh-rh)>1) return -1;

        return 1 + Math.max(lh, rh);
    }
}