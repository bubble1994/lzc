 public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node newHead = head;
        while (newHead != null) {
            if (!map.containsKey(newHead)) {
                Node node = new Node(newHead.val);
                map.put(newHead, node);
            }
            if (newHead.random != null) {
                Node random = newHead.random;
                if (!map.containsKey(random)) {
                    Node copyRandom = new Node(random.val);
                    map.put(random, copyRandom);
                }
                map.get(newHead).random = map.get(random);
            }
            newHead = newHead.next;
        }
        newHead = head;
        while (newHead != null) {
            Node next = newHead.next;
            map.get(newHead).next = map.get(next);
            newHead = newHead.next;
        }
        return map.get(head);
    }