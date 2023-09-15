class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if(s == null || s.length()==0) return result;
        backtrack(0, s, list, result);
        return result;
    }

    private void backtrack(int index, String s, List<String>list, List<List<String>> result) {

        if(index == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = index ; i<s.length(); i++) {
            if(isPalindrome(index, i, s)) {
                list.add(s.substring(index, i+1));
                backtrack(i+1, s, list, result);
                list.remove(list.size()-1);
            }
        }
        
    }


    private boolean isPalindrome(int start, int end, String s) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
}