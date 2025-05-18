class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0 ) return false;
        
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for(int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        for(int key : count.keySet()) {
            int freq = count.get(key);
            if(freq > 0) {
                for(int i=0; i<groupSize; i++) {
                    int curr = key+i;
                    if(count.getOrDefault(curr, 0) < freq) {
                        return false;
                    }
                    count.put(curr, count.get(curr) - freq);
                }
            }
        }

        return true;

    }
}