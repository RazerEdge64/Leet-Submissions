class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0]*a[0] + a[1]*a[1], b[0]*b[0] + b[1]*b[1])
        );

        for(int[] point: points) {
            pq.offer(point);
        }

        int[][] ans = new int[k][2];
        int i=0;
        while(i<k) {
            int[] temp = pq.poll();
            ans[i][0] = temp[0];
            ans[i][1] = temp[1];
            i++;
        }

        return ans;
    }
}