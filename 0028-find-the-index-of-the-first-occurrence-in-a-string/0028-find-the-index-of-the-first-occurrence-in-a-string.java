class Solution {
    public int strStr(String haystack, String needle) {
        String[] x = haystack.split(needle);
        if(x.length==1 && x[0].length() == haystack.length()) {
            return -1;
        }
        else if(x.length == 0) {
            return 0;
        }
        else{
            return x[0].length();
        }
        // return 0;
    }
}