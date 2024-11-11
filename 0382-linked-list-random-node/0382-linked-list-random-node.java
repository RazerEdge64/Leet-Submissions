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

import java.util.Random;

class Solution {
    private ListNode head;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }
    
    public int getRandom() {
        int index = 1;
        ListNode current = head;
        int result = current.val;

        while(current.next != null) {
            current = current.next;
            if(random.nextInt(index + 1) == 0) {
                result = current.val;
            }
            index++;
        }

        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */