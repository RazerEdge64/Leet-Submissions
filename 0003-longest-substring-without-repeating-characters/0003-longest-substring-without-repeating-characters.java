class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1) return 1;
        ArrayList<Character> aList = new ArrayList<>();
        
        for(int i=0; i<s.length()-1; i++) {
            ArrayList<Character> tempList = new ArrayList<>();
            for(int j=i; j<s.length(); j++) {
                if(tempList.contains(s.charAt(j))) break;
                tempList.add(s.charAt(j));
            }
            if(tempList.size() > aList.size()) {
                aList = tempList;
            }
        }
        
        return aList.size();
    }
}