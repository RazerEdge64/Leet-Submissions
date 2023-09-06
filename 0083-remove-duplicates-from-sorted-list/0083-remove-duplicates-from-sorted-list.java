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
    public ListNode deleteDuplicates(ListNode head) {

        ArrayList<Integer> list = new ArrayList();

        ListNode curr = head;
        ListNode dummy = new ListNode(0);

        while(curr!=null) {
            if(!list.contains(curr.val)){
                list.add(curr.val);
            }
            curr = curr.next;
        }
        Collections.sort(list);
        System.out.println(list);
        
        curr = dummy;
        for(int i=0; i<list.size(); i++) {
            curr.next = new ListNode(list.get(i));
            curr = curr.next;
        }

        return dummy.next;
        
        
    }
}