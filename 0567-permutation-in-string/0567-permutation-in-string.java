class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i=0; i<s1.length(); i++) {
            arr1[s1.charAt(i)-'a']++;
        }
        for(int i=0; i<s2.length(); i++) {
            arr2[s2.charAt(i)-'a']++;
            if(i>=n){
                arr2[s2.charAt(i-n)-'a']--;
            }
            if(Arrays.equals(arr1, arr2)) return true;
        }
        // now we have all the occurences of s2 and s1.

        return false;
    }
}