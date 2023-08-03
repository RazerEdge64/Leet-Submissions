class Solution {
    public boolean isSubsequence(String s, String t) {
        int pointer1=0, pointer2 = 0;
        
        while(pointer1<s.length() && pointer2<t.length()) {
            if(s.charAt(pointer1) == t.charAt(pointer2)) {
                pointer1++;
                pointer2++;
            }
            else {
                pointer2++;
            }
        }
        
        if(pointer1==s.length()) {
            return true;
        }
        return false;
    }
}