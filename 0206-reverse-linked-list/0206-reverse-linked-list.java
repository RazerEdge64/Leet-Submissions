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
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode dummy = new ListNode(0);
//         Stack<Integer> stack = new Stack<>();
        
//         ListNode current = head;
        
//         while(current!=null) {
//             stack.push(current.val);
//             current = current.next;    
//         }
//         current = dummy;
//         while(!stack.empty()) {
//             current.next = new ListNode(stack.pop());
//             current = current.next;
//         }
        
//         return dummy.next;
//     }
// }

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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode d = null;
        while(head!=null) {
            ListNode next = head.next;
            head.next = d;
            d = head;
            head = next;
        }
        return d;
    }

}