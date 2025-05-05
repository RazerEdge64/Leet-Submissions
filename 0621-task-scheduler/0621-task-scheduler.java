class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char c: tasks) {
            freq[c - 'A'] ++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int f: freq) {
            if(f>0) pq.offer(f);
        }

        int time = 0;

        while(!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            int i=0;
            for(; i<=n; i++) {
                if(!pq.isEmpty()) {
                    int curr = pq.poll();
                    if(curr>1) temp.add(curr-1);
                }
                time++;
                if(pq.isEmpty() && temp.isEmpty()) break;
            }

            for(int remaining: temp) pq.offer(remaining);
        }

        return time;


    }
}