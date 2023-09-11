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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        inOrder(root, pq);

        while(k>1) {
            pq.poll();
            k--;
        }

        return pq.peek();
    }

    private void inOrder(TreeNode root, PriorityQueue<Integer> pq) {
        if(root == null) return;


        if(root.left != null) inOrder(root.left, pq);
        pq.add(root.val);
        if(root.right != null) inOrder(root.right, pq);        
    }
}