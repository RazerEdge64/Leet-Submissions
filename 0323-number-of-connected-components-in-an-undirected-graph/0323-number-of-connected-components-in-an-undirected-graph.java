class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        int count = n;

        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            if(union(u, v, parent, rank)) {
                count--;
            }
        }

        return count;
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
        
        if(rank[parentV] > rank[parentU]) {
            parent[parentU] = parentV;
        } else if(rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
        } else {
            parent[parentV] = parentU;
            rank[parentU]++;
        }

        return true;
    }
}