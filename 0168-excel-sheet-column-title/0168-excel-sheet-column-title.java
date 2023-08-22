class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        int n = columnNumber;

        while(n>0) {
            n--;
            result.insert(0, (char)('A' + n % 26 ) );
            n /= 26;
        }

        return result.toString();

    }
}