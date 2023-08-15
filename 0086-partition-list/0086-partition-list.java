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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode res = dummy;

        // Nodes less than x;
        while(curr!=null) {
            if(curr.val < x) {
                res.next = new ListNode(curr.val);
                res = res.next;
            }
            curr = curr.next;
        }
        curr=head;
        while(curr!=null) {
            if(curr.val>=x) {
                res.next = new ListNode(curr.val);
                res = res.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}