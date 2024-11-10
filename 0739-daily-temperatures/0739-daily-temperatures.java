class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for(int currDay = 0; currDay<temperatures.length; currDay++) {
            while(!stack.empty() && temperatures[currDay] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                ans[prevDay] = currDay - prevDay;
            }
            
            stack.add(currDay);
        }
        
        return ans;
    }
}