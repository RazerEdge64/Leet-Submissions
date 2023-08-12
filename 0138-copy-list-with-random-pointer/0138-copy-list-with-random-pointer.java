/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

//         Node dummy = new Node(0);
//         Node iter = head;
//         HashMap<Node, Node> hashMap = new HashMap<>();
        
//         while(iter!=null) {
//             Node newNode = new Node(iter.val);
//             hashMap.put(iter, newNode);
//             iter = iter.next;
//         }

//         iter = head;
//         Node curr = dummy;

//         while(iter!=null) {
//             Node t = hashMap.get(iter);
//             t.next = (hashMap.get(iter.next)!=null) ? hashMap.get(iter.next) : null;
//             t.random = (hashMap.get(iter.random)!=null) ? hashMap.get(iter.random) : null;
            
//             curr.next = t;
//             curr = curr.next;
//             iter = iter.next;
//         }

//         return dummy.next;

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        
        Node dummy = new Node(0);
        
        Node copy = dummy;
        
        Node current = head;
        
        while(current!=null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        
        current = head;
        
        while(current!=null) {
            Node t = map.get(current);
            t.next = (map.get(current.next)!=null) ? map.get(current.next) : null;
            t.random = (map.get(current.random)!=null) ? map.get(current.random) : null;
            
            copy.next = t;
            copy = copy.next;
            current = current.next;
            
        }

        
        return dummy.next;


    }
}

































