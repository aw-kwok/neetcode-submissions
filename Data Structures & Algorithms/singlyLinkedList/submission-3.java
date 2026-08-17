class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public int get(int index) {
        Node curr = head;
        int count = 0;
        while (curr != null && count < index) {
            curr = curr.next;
            count++;
        }
        if (curr == null) return -1;
        return curr.val;
    }

    public void insertHead(int val) {
        head = new Node(val, head);
    }

    public void insertTail(int val) {
        if (head == null) {
            insertHead(val);
            return;
        }
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = new Node(val, null);
    }

    public boolean remove(int index) {
        if (head == null) return false;
        if (index == 0) {
            head = head.next;
            return true;
        }
        Node curr = head;
        Node prev = null;
        int count = 0;
        while (curr != null && count < index) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        if (curr == null) return false;
        prev.next = curr.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> soln = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            soln.add(curr.val);
            curr = curr.next;
        }
        return soln;
    }
}

class Node {
    int val;
    Node next;

    public Node(int i, Node n) {
        val = i;
        next = n;
    }
}
