class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> memo = new HashMap<>();
        return backtrack(s, 0, memo);
    }

    private int backtrack(String s, int index, Map<Integer, Integer> memo) {
        if(index == s.length()) {
            return 1;
        }

        if(memo.containsKey(index)) return memo.get(index);

        int total = 0;
        String c = s.substring(index, index+1);
        if(isValid(c)) {
            total+= backtrack(s, index+1, memo);
        }

        if(index+1 < s.length()) {
            String c2 = s.substring(index, index+2);
            if(isValid(c2)) {
                total+= backtrack(s, index+2, memo);
            }
        }

        memo.put(index, total);
        return total;
    }

    private boolean isValid(String s) {
        if(s.charAt(0) == '0') return false;
        int val = Integer.parseInt(s);
        return val>=1 && val<=26;
    }
}