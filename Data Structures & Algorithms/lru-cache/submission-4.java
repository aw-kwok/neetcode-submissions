class LRUCache {
    int capacity;
    Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int value = map.remove(key);
        map.put(key, value);
        return value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) map.remove(key);
        map.put(key, value);
        if (map.size() > capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
    }
}
