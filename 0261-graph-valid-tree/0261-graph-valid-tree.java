class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if(!union(u, v, parent, rank)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean union(int u, int v, int[] parent, int[] rank) {
        int parentU = find(u, parent);
        int parentV = find(v, parent);

        if(parentU == parentV) return false;

        if(rank[parentU] < rank[parentV]) {
            parent[parentU] = parentV;
        } else if(rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
        } else {
            parent[parentU] = parentV;
            rank[parentU] ++;
        }
        return true;
    }

    private int find(int x, int[] parent) {
        if(parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

}