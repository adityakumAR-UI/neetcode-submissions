class Node{
    int number;
    int value;
    Node prev=null;
    Node next=null;
    Node(int n,int v){
        this.number=n;
        this.value=v;
        this.prev=null;
        this.next=null;
    }
}
class LRUCache {
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    int capa;
    HashMap<Integer,Node> map=new HashMap<>();

    public LRUCache(int capacity) {
        head.next=tail;
        tail.prev=head;
        capa=capacity;
        
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node t=map.get(key);
            Node pre=t.prev;
            Node agla=t.next;
            pre.next=agla;
            agla.prev=pre;

            agla=head.next;
            head.next=t;
            t.prev=head;
            t.next=agla;
            agla.prev=t;
            return t.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            Node t=map.get(key);
            t.value=value;
            Node pre=t.prev;
            Node agla=t.next;
            pre.next=agla;
            agla.prev=pre;

            agla=head.next;
            head.next=t;
            t.prev=head;
            t.next=agla;
            agla.prev=t;
            return ;
            
        }
        if(map.size()==capa){
            Node last=tail.prev;
            Node pre=last.prev;
            pre.next=tail;
            tail.prev=pre;
            map.remove(last.number);
        }
        Node g=new Node(key,value);
        Node first=head.next;
        head.next=g;
        g.prev=head;
        g.next=first;
        first.prev=g;
        map.put(key,g);
        return ;
    }
}
