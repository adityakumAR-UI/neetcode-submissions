class MyHashMap {
    HashMap<Integer,Integer> map=new HashMap<>();
    public MyHashMap() {
        
    }
    
    public void put(int key, int value) {
        map.put(key,value);
        return ;
        
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
        
    }
    
    public void remove(int key) {
        map.remove(key);
        return;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */