class LRUCache {
    private class DoublyNode {
    int key;
    int value;
    DoublyNode prev;
    DoublyNode next;

    DoublyNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
HashMap<Integer, DoublyNode> lruCache = null;
    int capacity;
    DoublyNode head = new DoublyNode(0, 0);
    DoublyNode tail = new DoublyNode(0, 0);


    public LRUCache(int capacity) {
        lruCache = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new DoublyNode(0, 0);
        tail = new DoublyNode(0, 0);

        head.next = tail;
        tail.prev = head;

    }
    // 1 <-> 2 <-> 3
    public void addToFront(DoublyNode node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }


    public void remove(DoublyNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if(!lruCache.containsKey(key)){
            return -1;
        }
        DoublyNode currentNode = lruCache.get(key);
        remove(currentNode);
        addToFront(currentNode);
        return currentNode.value;
    }

    public void put(int key, int value) {
        //if key is not there in the map put then add it to front
        if(!lruCache.containsKey(key)){
            if(lruCache.size() == capacity){
                DoublyNode lru = tail.prev;
                remove(lru);
                lruCache.remove(lru.key);
            }
            DoublyNode newNode = new DoublyNode(key, value);
            lruCache.put(key,newNode);
            addToFront(newNode);
        }else{
            //if key is present  then just update it and move to front
            DoublyNode presnetKey = lruCache.get(key);
            presnetKey.value = value;
            remove(presnetKey);
            addToFront(presnetKey);
        }

    }

}
