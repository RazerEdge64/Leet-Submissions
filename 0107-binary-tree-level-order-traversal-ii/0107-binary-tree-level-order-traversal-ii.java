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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<ArrayList<Integer>> stack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return result;
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> list = new ArrayList();
            for(int i=0; i<levelSize; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                list.add(queue.poll().val);
            }
            stack.push(list);
        }
        
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }


        return result;
    }
}