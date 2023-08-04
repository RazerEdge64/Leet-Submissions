class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hM1 = new HashMap<>();
        HashMap<Character, Integer> hM2 = new HashMap<>();
        
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            hM1.put(c, hM1.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            hM2.put(c, hM2.getOrDefault(c, 0) + 1);
        }
        
        for (char c : hM1.keySet()) {
            if (!hM2.containsKey(c) || hM2.get(c) < hM1.get(c)) {
                return false;
            }
        }
        
        return true;
    }
}