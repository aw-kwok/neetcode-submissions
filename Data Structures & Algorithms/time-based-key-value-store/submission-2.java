class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<Pair<String, Integer>>());
        map.get(key).add(new Pair<String, Integer>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair<String, Integer>> arr = map.get(key);
        int l = 0;
        int r = arr.size() - 1;
        int m = -1;
        String soln = "";
        while (l <= r) {
            m = (l + r) / 2;
            Pair<String, Integer> entry = arr.get(m);
            if (entry.getValue() == timestamp) return entry.getKey();
            else if (timestamp < entry.getValue()) {
                r = m - 1;
            }
            else {
                l = m + 1;
                soln = entry.getKey();
            };
        }
        return soln;
    }
}
