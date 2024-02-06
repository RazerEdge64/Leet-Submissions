// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, List<String>> map = new HashMap<>();
        
//         for (String word : strs) {
//             char[] chars = word.toCharArray();
//             Arrays.sort(chars);
//             String sortedWord = new String(chars);
            
//             List<String> list = map.getOrDefault(sortedWord, new ArrayList<>());
//             if (!list.isEmpty()) {
//                 list.add(word);
//             } else {
//                 list.add(sortedWord);
//                 map.put(sortedWord, list);
//             }
//         }
        
//         return new ArrayList<>(map.values());
//     }
// }

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if(!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}