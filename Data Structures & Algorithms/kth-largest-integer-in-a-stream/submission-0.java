class KthLargest {
    PriorityQueue<Integer> maxHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i : nums) {
            maxHeap.add(i);
        }
        this.k = k;
    }
    
    public int add(int val) {
        maxHeap.add(val);
        List<Integer> popped = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            popped.add(maxHeap.poll());
        }
        
        int kth = popped.get(popped.size() - 1);

        for(int i : popped) {
            maxHeap.add(i);
        }

        return kth;
    }
}
