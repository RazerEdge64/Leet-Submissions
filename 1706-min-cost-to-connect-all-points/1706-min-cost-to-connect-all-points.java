class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<int[]> edges = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int dist = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, dist});
            }
        }

        edges.sort( (a, b) -> a[2] - b[2] );

        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i=0; i<n;i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgesUsed = 0;

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if(union(u, v, parent, rank)) {
                totalCost+=weight;
                edgesUsed++;
                if(edgesUsed == n-1) break;
            }
        }

        return totalCost;
    }

    private int find(int x, int[] parent) {
        if(parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private boolean union(int u, int v, int[] parent, int[] rank) {
        int parentU = find(u, parent);
        int parentV = find(v, parent);

        if(parentU == parentV) return false;

        if(rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
        } else if(rank[parentU] < rank[parentV]) {
            parent[parentU] = parentV;
        } else {
            parent[parentU] = parentV;
            rank[parentV]++;
        }
        return true;
    }
}