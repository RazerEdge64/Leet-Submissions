class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!visited[i]) {
                if(hasCycle(i, graph, visited, onPath, result)) {
                    return new int[0];
                }
            }
        }

        Collections.reverse(result);
        int[] order = new int[numCourses];
        for(int i=0; i< numCourses; i++) {
            order[i] = result.get(i);
        }

        return order;
    }

    private boolean hasCycle(int node, List<List<Integer>> graph, boolean[] visited, boolean[] onPath, List<Integer> result) {
        visited[node] = true;
        onPath[node] = true;

        for(int neighbor: graph.get(node)) {
            if(!visited[neighbor]) {
                if(hasCycle(neighbor, graph, visited, onPath, result)) {
                    return true;
                }
            } else if(onPath[neighbor]) {
                return true;
            }
        }
        onPath[node] = false;
        result.add(node);
        return false;
    }
} 