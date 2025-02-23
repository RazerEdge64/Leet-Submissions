class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hMap = new HashMap<>();

        for(int i: nums) {
            hMap.put(i, hMap.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> hMap.get(a) - hMap.get(b));

        for(int num: hMap.keySet()) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];

        for(int i=0; i<k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}