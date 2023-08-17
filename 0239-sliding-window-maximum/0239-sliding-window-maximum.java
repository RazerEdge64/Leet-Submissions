class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

    int[] result = new int[nums.length-k+1];
    int left = 0;
    Deque<Integer> q = new LinkedList<>();

    for (int right = 0; right < nums.length; right++) {
        // Remove indices that are out of the current window
        while (!q.isEmpty() && q.peekFirst() < right - k + 1) {
            q.pollFirst();
        }

        // Remove indices whose corresponding values are less than current element
        while (!q.isEmpty() && nums[q.peekLast()] < nums[right]) {
            q.pollLast();
        }

        // Add the current element's index
        q.offer(right);

        // If we've at least seen k elements, add the current max to result
        if (right >= k - 1) {
            result[right - k + 1] = nums[q.peekFirst()];
        }
    }

    return result;


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



}
}