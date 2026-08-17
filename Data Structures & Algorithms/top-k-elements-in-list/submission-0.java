class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer>[] count = new ArrayList[nums.length + 1];

        for (int i = 0; i < count.length; i++) {
            count[i] = new ArrayList<Integer>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        int[] soln = new int[k];
        for (int i = count.length - 1; i >= 0 && index != k; i--) {
            if (!count[i].isEmpty()) {
                for (int j = 0; j < count[i].size(); j++) {
                    soln[index++] = count[i].get(j);
                }
            }
        }
        return soln;
    }
}
