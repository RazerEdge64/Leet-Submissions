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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int[] helper = new int[] {Integer.MAX_VALUE};

        findDepth(root, 1, helper);

        return helper[0];
    }

    private void findDepth(TreeNode root, int depth, int[] helper) {
        if(root == null) return;

        if(root.left == null && root.right == null ) {
            helper[0] = Math.min(helper[0], depth);
            return;
        }

        findDepth(root.left, depth+1, helper);
        findDepth(root.right, depth+1, helper);
    }
}