class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(int i=0; i<tokens.length; i++) {
            String token = tokens[i];
            if(token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                String token1 = stack.pop();
                String token2 = stack.pop();
                int result = 0;
                if(token.equals("+")) {
                    result = Integer.parseInt(token1) + Integer.parseInt(token2);
                }
                if(token.equals("-")) {
                    result = Integer.parseInt(token2) - Integer.parseInt(token1);
                }
                if(token.equals("*")) {
                    result = Integer.parseInt(token2) * Integer.parseInt(token1);
                }
                if(token.equals("/")) {
                    result = Integer.parseInt(token2) / Integer.parseInt(token1);
                }
                stack.push(result+"");
                continue;
            }
            stack.push(token);
        }
        return Integer.parseInt(stack.peek());
    }
}