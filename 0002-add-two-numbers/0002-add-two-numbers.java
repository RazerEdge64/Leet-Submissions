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

//         ListNode dummy = new ListNode(0);
//         ListNode curr = dummy;
//         int carry = 0;

//             while (l1 != null || l2 != null) {
//         int sum = carry;

//         if (l1 != null) {
//             sum += l1.val;
//             l1 = l1.next;
//         }
//         if (l2 != null) {
//             sum += l2.val;
//             l2 = l2.next;
//         }

//         carry = sum / 10;
//         curr.next = new ListNode(sum % 10);
//         curr = curr.next;
//     }

//     if (carry > 0) {
//         curr.next = new ListNode(carry);
//     }

//     return dummy.next;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        
        while(l1!=null && l2!=null) {
            int sum = l1.val + l2.val + carry;
            if(sum > 9) {
                carry = 1;
                sum = sum%10;
            } else {
                carry = 0;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
                
        while(l1!=null) {
            System.out.println("here");
            int sum = l1.val + carry;
            if(sum>9) {
                carry = 1;
                sum = sum%10;
            } else {
                carry = 0;
            }
            System.out.println(carry+ " "+sum);
            curr.next = new ListNode(sum);
            curr = curr.next;
            l1 = l1.next;
        }
        
        while(l2!=null) {
            int sum = l2.val + carry;
            if(sum>9) {
                carry = 1;
                sum = sum%10;
            } else {
                carry = 0;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;
            l2 = l2.next;
        }
        
        if(carry>0) {
            System.out.println("Here");
            curr.next = new ListNode(1);
        }
        
        
        return dummy.next;
    }

}



































