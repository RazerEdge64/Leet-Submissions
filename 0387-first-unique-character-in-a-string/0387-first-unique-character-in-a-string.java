class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hMap = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            hMap.put(c, hMap.getOrDefault(c, 0) + 1);
        }
        
        for(int i=0; i<s.length(); i++) {
            if(hMap.get(s.charAt(i)) == 1) {
                return i;
            }    
        }
        
        return -1;
        
    }
}