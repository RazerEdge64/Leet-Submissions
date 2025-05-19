class Solution {
    public int[][] merge(int[][] intervals) {
        // sort the array on start
        // maintain a list of merged 
        // if start i+1 < end i -> merge
        List<int[]> merged = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        for(int[] interval : intervals) {
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0] ) {
                merged.add(interval);
            } else {
                merged.get(merged.size()-1)[1] = Math.max(  merged.get(merged.size()-1)[1] , interval[1] );
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}