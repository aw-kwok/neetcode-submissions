class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // put nums and frequencies into HashMap
        HashMap<Integer, Integer> map = new HashMap();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // use buckets
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        // HashMap to bucket
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            bucket[e.getValue()].add(e.getKey());
        }

        // iterate through buckets array backwards
        int[] soln = new int[k];
        int j = k - 1;
        for(int i = bucket.length - 1; i >= 0; i--) {
            while (j >= 0 && !bucket[i].isEmpty()) {
                soln[j] = bucket[i].remove(0);
                j--;
            }
            if (j < 0) return soln;
        }
        
        return new int[]{};
    }
}
