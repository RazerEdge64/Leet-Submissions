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
        return goodNotes(root, Integer.MIN_VALUE);
    }

    private int goodNotes(TreeNode root, int ma) {
        if(root == null) return 0;

        int res = root.val >= ma ? 1 : 0;

        res += goodNotes(root.left, Math.max(ma, root.val));
        res += goodNotes(root.right, Math.max(ma, root.val));

        return res;
    }
}