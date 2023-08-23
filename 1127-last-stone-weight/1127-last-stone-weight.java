class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i : stones) pq.add(i);

        while(pq.size()>=2) {
            int x = pq.poll();
            int y = pq.poll();
            if(x==y) continue;
            pq.add(Math.abs(x-y));
        }

        if(pq.size()==0) return 0;
        if(pq.size()==1) return pq.poll();

        return Math.abs(pq.poll() - pq.poll());




        // return 0;
    }
}