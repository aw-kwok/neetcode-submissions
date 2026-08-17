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

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>(); // old, new
        Node curr = head;
        while (curr != null) {
            Node temp = new Node(curr.val);
            map.put(curr, temp);
            curr = curr.next;
        }

        curr = head;
        while(curr != null) {
            Node temp = map.get(curr);
            if (curr.next != null) {
                temp.next = map.get(curr.next);
            }
            if (curr.random != null) {
                temp.random = map.get(curr.random);
            }
            curr = curr.next;
        }
        return map.get(head);
    }
}
