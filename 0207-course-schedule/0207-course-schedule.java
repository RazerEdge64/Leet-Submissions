class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] pair: prerequisites) {
            graph.get(pair[1]).add(pair[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!visited[i]) {
                if(hasCycle(graph, i, visited, onPath)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int node, boolean[] visited, boolean[] onPath) {
        visited[node] = true;
        onPath[node] = true;

        for(int neighbor: graph.get(node)) {
            if(!visited[neighbor]) {
                if( hasCycle(graph, neighbor, visited, onPath)) return true;
            } else if (onPath[neighbor]) {
                return true;
            }
        }

        onPath[node] = false;

        return false;
    }
}