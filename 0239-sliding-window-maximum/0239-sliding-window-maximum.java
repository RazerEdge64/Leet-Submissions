class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       if(nums == null || k==0) return new int[0];

       int n = nums.length;
       int[] result = new int[n-k + 1];
       Deque<Integer> deque = new LinkedList<>();

       for(int right = 0; right<n; right++) {
            while(!deque.isEmpty() && deque.peekFirst() < right-k+1) {
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }

            deque.offerLast(right);

            if(right >= k-1) {
                result[right-k+1] = nums[deque.peekFirst()];
            }
       }

       return result;
    }
}