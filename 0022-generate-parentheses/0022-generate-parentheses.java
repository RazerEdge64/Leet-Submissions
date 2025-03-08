class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> str = new ArrayList<>();
        backtrack(str, "", 0, 0, n);
        
        return str;
    }
    
    
    public void backtrack(List<String> str, String string, int open, int close, int max) {
        if(string.length() == max*2) {
            str.add(string);
            return;
        }
        
        if(open < max) {
            backtrack(str, string+"(", open+1, close, max);    
        }
        
        if(close < open) {
            backtrack(str, string+")", open, close+1, max);
        }
        
    }

}