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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode answer = dummy;
        
        ListNode curr = head;
        
        while(curr!=null) {
            if(curr.val != val) {
                dummy.next = new ListNode(curr.val);
                dummy = dummy.next;
            }
            curr = curr.next;
        }
        
        
        return answer.next;
        
        
    }
}