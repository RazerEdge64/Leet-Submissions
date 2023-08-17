class Solution {
    public int lengthOfLongestSubstring(String s) {
    //     if(s.length()==0) {
    //         return 0;
    //     }
    //     int ans = Integer.MIN_VALUE;
    //     int l=0;
    //     Set<Character> set = new HashSet<>();
        
    //     for(int r=0; r<s.length(); r++) {
            
    //         if(set.contains(s.charAt(r))) {
    //             // Remove from set
    //             while(l<r && set.contains(s.charAt(r))) {
    //                 set.remove(s.charAt(l));
    //                 l++;
    //             }
    //         }
            
    //         set.add(s.charAt(r));
    //         ans = Math.max(ans, r-l+1);
    //     }
        
    //     return ans;


        int[] chars = new int[128];

        int left=0;
        int right = 0;
        int result = 0;

        while(right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;
            while(chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }
            result = Math.max(result, right - left +1);
            right++;
        }
        
        return result;
        
        
    }
}