class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int[] flight: flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        // cost, node, stops
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[0] - b[0]);
        pq.offer(new int[] {0, src, 0});

        Map<Integer, Integer> minStops = new HashMap<>();

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int city = curr[1];
            int stops = curr[2];

            if(minStops.containsKey(city) && minStops.get(city) <= stops) continue;
            minStops.put(city, stops);

            if(city == dst) return cost;
            if(stops > k) continue;

            if(!graph.containsKey(city)) continue;

            for(int[] nei : graph.get(city)) {
                int nextCity = nei[0];
                int price = nei[1];
                pq.offer(new int[]{cost + price, nextCity, stops+1});
            }
        }

        return -1;
    }
}