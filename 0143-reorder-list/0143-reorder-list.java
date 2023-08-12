/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return; // No need to reorder for small lists
        }

        // Use a stack to store the second half of the list
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null; // Break the first and second halves
        
        while (secondHalf != null) {
            stack.push(secondHalf);
            secondHalf = secondHalf.next;
        }

        // Merge the two halves by popping from the stack
        ListNode current = head;
        while (!stack.isEmpty()) {
            ListNode next = current.next;
            ListNode secondNode = stack.pop();
            current.next = secondNode;
            secondNode.next = next;
            current = next;
        }
    }

}