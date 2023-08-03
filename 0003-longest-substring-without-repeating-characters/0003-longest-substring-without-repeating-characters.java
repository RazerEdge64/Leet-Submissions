class Solution {
    public int lengthOfLongestSubstring(String s) {
//         if(s.length()==0) return 0;
//         if(s.length()==1) return 1;
//         ArrayList<Character> aList = new ArrayList<>();
        
//         for(int i=0; i<s.length()-1; i++) {
//             ArrayList<Character> tempList = new ArrayList<>();
//             for(int j=i; j<s.length(); j++) {
//                 if(tempList.contains(s.charAt(j))) break;
//                 tempList.add(s.charAt(j));
//             }
//             if(tempList.size() > aList.size()) {
//                 aList = tempList;
//             }
//         }
        
//         return aList.size();
        if(s.length()==0) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        int l=0;
        Set<Character> set = new HashSet<>();
        
        for(int r=0; r<s.length(); r++) {
            
            if(set.contains(s.charAt(r))) {
                // Remove from set
                while(l<r && set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            
            set.add(s.charAt(r));
            ans = Math.max(ans, r-l+1);
        }
        
        return ans;
        
    }
}