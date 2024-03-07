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
    public ListNode middleNode(ListNode head) {
        // ListNode copy_h = head;
        // int size = 0;

        // while(copy_h!=null) {
        //     size++;
        //     copy_h = copy_h.next;
        // }

        // int mid = 0;
        // if(size%2 == 0) {
        //     mid = size/2;
        // }
        // else{
        //     mid = size/2;
        // }

        // int iterator = 0;
        // while(head!=null) {
        //     if(iterator == mid) {
        //         return head;
        //     }
        //     head = head.next;
        //     iterator++;
        // }

        // return head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;


    }
}