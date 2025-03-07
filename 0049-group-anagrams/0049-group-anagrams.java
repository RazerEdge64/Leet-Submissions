class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mainMap = new HashMap<>();
        // key is sorted str ; values are all those which are anagrams.

        for(int i=0; i<strs.length; i++) {
            String s = strs[i];
            char[] carr = s.toCharArray();
            Arrays.sort(carr);
            String sortedStr = String.valueOf(carr);

            if(mainMap.containsKey(sortedStr)) {
                mainMap.get(sortedStr).add(s);
            }
            else {
                mainMap.put(sortedStr, new ArrayList<String>());
                mainMap.get(sortedStr).add(s);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(List<String> l : mainMap.values()) {
            result.add(l);
        }

        return result;
    }
}