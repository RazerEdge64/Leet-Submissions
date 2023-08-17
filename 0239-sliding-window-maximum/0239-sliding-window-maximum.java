class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    //     int[] result = new int[nums.length-k+1];
    //     int left = 0;
    //     int max = Integer.MIN_VALUE;
    //     for(int right = 0; right<nums.length; right++) {
    //         // max = Math.max(max, nums[right]);
            
    //         if(right>=k-1) {
    //             // if(nums[left]==max) {
    //             System.out.println(left+" "+right);
    //             max = nextMax(left, right, nums);
    //             // }
    //             result[left] = max;
    //             left++;
    //         }
            
    //     }

    //     return result;
    // }

    // private int nextMax(int a, int b, int[] nums) {
    //     int max = Integer.MIN_VALUE;
    //     for(int i=a; i<=b; i++) {
    //         if(nums[i]>max){
    //             max = nums[i];
    //         }
    //     }

    //     return max;
    // }

    int[] result = new int[nums.length-k+1];
    int left = 0;
    Deque<Integer> q = new LinkedList<>();

    for(int right = 0; right<nums.length; right++) {

        // 
        if(!q.isEmpty() && q.peekFirst() < right-k+1 )
            q.pollFirst();
        
        while(!q.isEmpty() && nums[right] > nums[q.peekLast()])
            q.pollLast();

        q.offer(right);
        
        if(right >= k-1)
            result[left++] = nums[q.peekFirst()];
    }

    return result;

}
}