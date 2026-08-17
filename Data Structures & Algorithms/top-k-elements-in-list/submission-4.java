class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer>[] arr = new ArrayList[nums.length + 1];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            arr[e.getValue()].add(e.getKey());
        }

        int index = k - 1;
        int[] soln = new int[k];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!arr[i].isEmpty()) {
                soln[index] = arr[i].remove(0);
                index--;
                if (index < 0) return soln;
            }
            
        }
        return soln;
    }
}
