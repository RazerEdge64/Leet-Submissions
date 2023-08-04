import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str1 = pattern.split("");
        String[] str2 = s.split(" ");
        
        if (str1.length != str2.length)
            return false;
        
        HashMap<String, String> hashMap = new HashMap<>();
        
        for (int i = 0; i < str1.length; i++) {
            if (hashMap.containsKey(str1[i])) {
                if (!hashMap.get(str1[i]).equals(str2[i])) {
                    return false;
                }
            } else {
                if (hashMap.containsValue(str2[i])) {
                    return false;
                }
                hashMap.put(str1[i], str2[i]);
            }
        }
        
        return true;
    }
}
