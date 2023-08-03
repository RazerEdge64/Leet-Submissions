class Solution {
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        partitionHelper(0, s, list, ans);
        return ans;
    }

    public static void partitionHelper(int index, String s, List<String> list, List<List<String>> ans) {
        if(index == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=index ; i<s.length() ; i++) {
            if(isPalindrome(s, index , i)) {
                list.add(s.substring(index, i+1));
                partitionHelper(i+1, s, list, ans);
                list.remove(list.size()-1);
            }

        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while(start<=end) {
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }


}