class Solution {
    public String reverseStr(String s, int k) {
        int index = 0;
        int limit = k;

        char[] charArr = s.toCharArray();
        
        while(index < s.length()) {
            int start = index;
            int end = ((index + k) > s.length()) ? s.length()-1 : index+k-1;

            while(start < end) {
                char temp = charArr[end];
                charArr[end] = charArr[start];
                charArr[start] = temp;

                start++;
                end--;                
            }
            
            index = index + 2*k;
        }

        return new String(charArr);
    }
}