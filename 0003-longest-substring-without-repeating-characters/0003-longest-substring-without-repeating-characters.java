class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int l=0;
        if(s.length() == 0) return 0;

        for(int r=0; r<s.length(); r++) {
            if(set.contains(s.charAt(r))) {
                while( l<r && set.contains(s.charAt(r)) ) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(s.charAt(r));
            ans = Math.max(ans, set.size());
        }

        return ans;
    }
}