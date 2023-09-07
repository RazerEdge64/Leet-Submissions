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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode curr = head;

        while(curr!=null) {
            length++;
            curr = curr.next;
        }

        // Step 2: Determine the size of each part.
        int baseSize = length / k;
        int extra = length % k;

        ListNode[] result = new ListNode[k];

        int loopIterator = 0;
        curr = head;

        for (int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(0);
            ListNode temp = dummy;

            // Assign baseSize nodes for each part. Assign an additional node for first 'extra' parts.
            int partSize = baseSize + (i < extra ? 1 : 0);
            for (int j = 0; j < partSize; j++) {
                temp.next = curr;
                temp = curr;
                curr = curr.next;
            }
            temp.next = null; // Disconnect the part from the rest of the list.
            result[i] = dummy.next;
        }

        return result;
    }
}