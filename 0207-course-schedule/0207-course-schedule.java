class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        // Intializing the graph
        for(int i=0; i<numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the graph
        for(int[] pair : prerequisites) {
            graph[pair[1]].add(pair[0]);
            inDegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i< numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int visitedNodes = 0;

        while(!queue.isEmpty()) {
            int current =  queue.poll();
            visitedNodes++;

            for(int neighbor : graph[current]) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return visitedNodes == numCourses;




     }
}