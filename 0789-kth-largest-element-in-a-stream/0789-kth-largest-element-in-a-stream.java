class KthLargest {

    private final PriorityQueue<Integer> pq;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;

        for(int i=0; i<nums.length; i++) {
            pq.offer(nums[i]);
            if(pq.size() > k) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */