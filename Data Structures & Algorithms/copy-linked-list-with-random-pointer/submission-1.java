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
        HashMap<Node,Node> map = new HashMap<>();
        Node current = head;
        while(current != null){
            Node copy = getNode(current, map);
            copy.next = getNode(current.next, map);
            copy.random = getNode(current.random, map);
            current = current.next;
        }
        return getNode(head, map);
    }

    public Node getNode(Node node, HashMap<Node,Node> map){
        if(node == null){
            return null;
        }
        if(!map.containsKey(node)){
            map.put(node, new Node(node.val));
        }
        return map.get(node);
    }
}
