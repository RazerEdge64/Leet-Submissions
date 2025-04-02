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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;

        // Need a recursive function to maintain the max.
        int result = dfs(root, root.val);

        return result;
    }

    private int dfs(TreeNode root, int max) {
        if(root == null) return 0;

        int count = (root.val >= max) ? 1 : 0;

        int newMax = Math.max(max, root.val);

        count += dfs(root.left, newMax);
        count += dfs(root.right, newMax);

        return count;
    }
}