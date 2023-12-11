class Solution {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        
        for(int i=0; i<arr.length; i++) {
            hMap.put(arr[i], hMap.getOrDefault(arr[i], 0) + 1);
        }
        int twentyFive = (int)(0.25 * arr.length);
        int ans = 0;
        System.out.println(twentyFive);
        for(Map.Entry<Integer, Integer> i : hMap.entrySet()) {
            System.out.println(i.getKey()+" "+ i.getValue());
            if(i.getValue() > twentyFive) {
                ans = i.getKey();
            }
        }
        
        return ans;
    }
}