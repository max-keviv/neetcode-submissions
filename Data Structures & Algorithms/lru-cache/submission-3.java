class LRUCache {
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node start = new Node(0,0);
    Node end = new Node(0,0);

    Map<Integer, Node> cache = new HashMap<>();
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        start.next = end;
        end.prev = start;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) return -1;
        moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node != null)
        {
            node.value = value;
            moveToFront(node);
            return;
        }
        if(cache.size() == capacity) {
            Node lru = end.prev;
            remove(lru);
            cache.remove(lru.key);
        }
        Node newNode = new Node(key,value);
        addFirst(newNode);
        cache.put(key,newNode);
    }
    public void moveToFront(Node node){
        remove(node);
        addFirst(node);
    }
    public void addFirst(Node node){
        node.next = start.next;
        node.prev = start;
        start.next.prev = node;
        start.next = node;
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
}
