class Solution {
    private Map<Character, String> numPad = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );


    public List<String> letterCombinations(String digits) {     
        List<String> result = new ArrayList<>();
        if(digits.length()==0) return result;

        String cur = "";
        backtrack(digits, result, cur, 0);
        return result;
    }

    private void backtrack(String digits, List<String> result, String cur, int index) {
        if(cur.length() == digits.length()) {
            result.add(cur);
            return;
        } else if(index >= digits.length()) {
            return;
        } else {
            String digit = numPad.get(digits.charAt(index));

            for(char c : digit.toCharArray()) {
                backtrack(digits, result, cur + c, index +1 );
            }
        }
    }
    
}