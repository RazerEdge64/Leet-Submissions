class Solution {
    public int findLongestChain(int[][] pairs) {
            PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)-> a[1] - b[1] );

            for(int[] i : pairs) {
                pq.add(i);
            }

            int previous = 0;
            int count = 0;
            int index = 0;
            while(!pq.isEmpty()) {

                if(index == 0 ) {
                    previous = pq.peek()[1];
                    count++;
                    index++;
                    pq.poll();
                    continue;
                }

                int current = pq.peek()[0];
                if(current > previous) {
                    previous = pq.peek()[1];
                    count++;
                    index++;
                }
                pq.poll();
                // System.out.println(pq.peek()[0]+" "+pq.peek()[1]);
                // pq.poll();

            }

            return count;
    }
}