class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        
        String originalStr = Integer.toString(x);

        StringBuilder sb = new StringBuilder(originalStr);

        String reversedStr = sb.reverse().toString();

        return originalStr.equals(reversedStr);

    }
}