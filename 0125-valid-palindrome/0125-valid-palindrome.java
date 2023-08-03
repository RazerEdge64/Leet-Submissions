class Solution {
    public boolean isPalindrome(String s) {
        String str = "";
        boolean res = true;
        
        for(int i=0; i<s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))) {
                str+=s.charAt(i);
            }
        }
        
        str = str.toLowerCase();
        if(str.length()==0 || str.length()==1) return true;
        
        int start = 0, end = str.length()-1;
        
        while(start<end) {
            if(str.charAt(start)!=str.charAt(end)) return false;
            start++;
            end--;
        }
        
        
        
        return true;
    }
}