class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hMap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            
            char c = s.charAt(i);
            
            hMap.put(c, hMap.getOrDefault(c, 0) + 1);
        }
        
        for(int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            
            hMap.put(c, hMap.getOrDefault(c, 0) - 1);
        }
        
        for(Integer i : hMap.values()) {
            if(i>0) {
                return false;
            }
        }
        
        return true;
    }
}