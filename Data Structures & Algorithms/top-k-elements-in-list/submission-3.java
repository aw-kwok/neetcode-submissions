class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {            
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] arr = new List[nums.length + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e);
            arr[e.getValue()].add(e.getKey());
        }

        int[] soln = new int[k];

        int j = k - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!arr[i].isEmpty()) {
                soln[j] = arr[i].remove(0);
                j--;
                if (j < 0) return soln;
            }
        }
        return soln;

    }
}
