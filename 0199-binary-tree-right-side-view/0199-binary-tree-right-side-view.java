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
    public List<Integer> rightSideView(TreeNode root) {
        // Level order traversal.

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        if(root == null) return list;

        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                if(i==size-1) list.add(q.peek().val);
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                q.poll();
            }
        }

        return list;
    }
}