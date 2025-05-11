class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: times ) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[] {v, w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], node = curr[1];

            if(time > dist[node]) continue;

            for(int[] nei: graph.get(node)) {
                int nextNode = nei[0], weight = nei[1];
                if(dist[nextNode] > time+weight) {
                    dist[nextNode] = time+weight;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }

        int maxTime = 0;
        for(int i=1; i<=n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}