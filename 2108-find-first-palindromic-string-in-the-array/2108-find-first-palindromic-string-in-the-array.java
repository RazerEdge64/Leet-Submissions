class Solution {
    public String firstPalindrome(String[] words) {
        
        for(int i=0; i<words.length ; i++) {
            if(checkPalindrome(words[i])) {
                return words[i];
            }
        }
        
        return "";
    }
    
    private static boolean checkPalindrome(String word) {
        int start = 0;
        int end = word.length()-1;
        
        while(start<end) {
            if(word.charAt(start) != word.charAt(end)) {
                return false;
            }
            else {
                start++;
                end--;
            }
        }
        
        return true;
    }
}