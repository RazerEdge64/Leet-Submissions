class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int answer = 0;
        
        for(int i=0; i<chars.length(); i++) {
            hashMap.put(chars.charAt(i), hashMap.getOrDefault(chars.charAt(i), 1) + 1);
        }
        
        // Loop for words.
        for(int i=0; i<words.length; i++) {
            HashMap<Character, Integer> tempMap = new HashMap<>();
            
            for(int j=0; j<words[i].length(); j++) {
                tempMap.put( words[i].charAt(j), tempMap.getOrDefault(words[i].charAt(j), 1) + 1);
            }
            
            // Now we have 2 hashMaps.
            boolean flag = true;
            
            for(char c : tempMap.keySet()) {
                if(!hashMap.containsKey(c) || hashMap.get(c) < tempMap.get(c)) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                answer += words[i].length();
            }
            
        }
        
        return answer;
        
    }
}