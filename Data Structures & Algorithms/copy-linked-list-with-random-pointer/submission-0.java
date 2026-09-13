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
         HashMap<Node,Node> addressMap = new HashMap<>();
        Node current = head;
        //IN this pass we created the deep copy of all the objects
        while(current != null){
            Node newNode = new Node(current.val);
            addressMap.put(current, newNode);
            current = current.next;
        }
        //next pass
        current = head;
        while(current != null){
            Node copy = addressMap.get(current);
            copy.next = addressMap.get(current.next);
            copy.random = addressMap.get(current.random);
            current = current.next;
        }
        return addressMap.get(head);//see that will be new node
    }
}
