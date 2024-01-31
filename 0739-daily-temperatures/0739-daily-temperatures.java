class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] answers = new int[n];

        for(int currDay = 0; currDay<n; currDay++) {
            while(!stack.isEmpty() && temperatures[currDay] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                answers[prevDay] = currDay - prevDay;
            }

            stack.add(currDay);
        }

        return answers;
    }
}