
class Node {
    int key;
    int value;
    Node prev;
    Node next;
    public Node(){
    }
    public Node(int key,int value)
    {
        this.key = key;
        this.value = value;
    }
    public Node(int key,int value,Node prev,Node next)
    {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

class DoubleLinkedList {
    Node start;
    Node end;
    int size;
    public DoubleLinkedList() {
        Node start = new Node(0,0,null,null);
        Node end = new Node(0,0,start,null);
        start.next = end;
        this.start = start;
        this.end = end;
        this.size = 0;
    }
    public void remove(Node item){
        item.prev.next = item.next;
        item.next.prev = item.prev;
        item.prev = null;
        item.next = null;
        // delete(item);
        this.size--;
    }
    public Node add(int key,int value){
        Node head = start;
        Node newNode = new Node(key,value,start,start.next);
        head.next.prev = newNode;
        head.next = newNode;
        this.size++;
        return newNode;
    }
    public Node pop(){
        if(start.next == end && start == end.prev) return null;
        Node last = end.prev;
        last.prev.next = last.next;
        last.next.prev = last.prev;
        this.size--;
        return last;
    }
    public int size(){
        return size;
    }
}

class LRUCache {

    HashMap<Integer,Node> keyValue;
    DoubleLinkedList queue;
    int capacity;
    public LRUCache(int capacity) {
        keyValue = new HashMap<>();
        queue = new DoubleLinkedList();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(keyValue.get(key) == null) return -1;

        Node node = keyValue.get(key);
        queue.remove(node);
        Node added = queue.add(node.key,node.value);

        keyValue.put(key,added);
        return added.value;
    }
    
    public void put(int key, int value) {
        if(keyValue.get(key)!=null) queue.remove(keyValue.get(key));
        Node newNode = queue.add(key,value);
        keyValue.put(key,newNode);
        // System.out.println(queue.size());
        if(queue.size() > capacity){
            // System.out.println("overflow");
            Node removed = queue.pop();
            // System.out.println("size "+queue.size());
            keyValue.remove(removed.key);
        }
    }
}
