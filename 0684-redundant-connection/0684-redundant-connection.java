class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=1; i<=n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            if(!union(u, v, parent, rank)) {
                return edge;
            }
        }

        return new int[0];
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