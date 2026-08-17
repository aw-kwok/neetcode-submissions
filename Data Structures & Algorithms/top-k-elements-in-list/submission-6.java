class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return map.get(b) - map.get(a);
        });

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e.getKey());
        }

        int[] soln = new int[k];
        for (int i = 0; i < k; i++) {
            soln[i] = pq.poll();
        }
        return soln;
    }
}
