class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        Map<Integer, Boolean> memo = new HashMap<>();
        return recurse(s, set, memo, 0);
    }

    private boolean recurse(String s, Set<String> wordDict, Map<Integer, Boolean> memo, int index) {
        if(index == s.length()) {
            return true;
        }
        if(memo.containsKey(index)) return memo.get(index);

        for(int i=index; i<s.length(); i++) {
            if(wordDict.contains(s.substring(index, i+1))) {
                if(recurse(s, wordDict, memo, i+1)) {
                    memo.put(index, true);
                    return true;
                }
            }
        }
        memo.put(index, false);
        return false; 
    }
}