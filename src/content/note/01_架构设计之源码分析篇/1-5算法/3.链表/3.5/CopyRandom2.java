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
        if (head == null) {
            return null;
        }
        copy(head);
        copyRandom(head);
        return split(head);
    }
    public void copy(Node head) {
        Node node = head;
        while(node != null) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
    }
    
    public void copyRandom(Node head) {
        Node node = head;
        while(node != null && node.next != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
    }
    
    public Node split(Node head) {
        Node result = head.next;
        Node move = head.next;
        while(head != null && head.next != null) {
            head.next = head.next.next;
            head = head.next;
            if (move != null && move.next != null) {
                move.next = move.next.next;
                move = move.next;
            }
        }
        return result;
    }
}