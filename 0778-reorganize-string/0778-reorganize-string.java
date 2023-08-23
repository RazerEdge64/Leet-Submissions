class Solution {
    public String reorganizeString(String s) {
        if(s==null || s.length() ==0 ) return "";

        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Step 2: Put these characters in a priority queue based on their frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)-> counts.get(b) - counts.get(a));
        maxHeap.addAll(counts.keySet());

        StringBuilder result = new StringBuilder();

        while(maxHeap.size() > 1) {
            char current = maxHeap.poll();
            char next = maxHeap.poll();

            result.append(current);
            result.append(next);

            // Decrease the count of the current and next characters
            counts.put(current, counts.get(current) - 1);
            counts.put(next, counts.get(next) - 1);
            
            if (counts.get(current) > 0) {
                maxHeap.add(current);
            }

            if (counts.get(next) > 0) {
                maxHeap.add(next);
            }
        }

        // Handle the case where only one type of character is left in the heap
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.poll();
            if (counts.get(last) > 1) {
                return ""; // Cannot rearrange string
            }
            result.append(last);
        }
        
        return result.toString();






        
    }
}