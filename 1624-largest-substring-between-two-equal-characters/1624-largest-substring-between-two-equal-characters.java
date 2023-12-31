class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            for(int j=s.length()-1; j>i; j--) {
                
                if(c == s.charAt(j)) {
                    int len = j-i-1;
                    if(len > max) {
                        max = len;    
                    }
                    
                }
            }
        }
        
        return max;
    }
}