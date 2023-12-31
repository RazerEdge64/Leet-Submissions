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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int flag = 0;
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        q.offer(root);

        while(!q.isEmpty()) {
            int level = q.size();
            List<Integer> list = new ArrayList<>();
            
            for(int i=0; i<level; i++) {

                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);                
                list.add(q.poll().val);              
            }

            if(flag == 0) {
                flag = 1;
            }
            else {
                Collections.reverse(list);
                flag = 0;
            }

            result.add(list);
        }


        return result;
    }
}