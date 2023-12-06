class Solution {
    public int totalMoney(int n) {
        int mondayCycle = 0;
        int sum = 0;
        
        if(n<7) {
            for(int i=1; i<=n; i++) {
                sum+=i;
            }
            return sum;
        }
        
        int totalCycles = n/7;
        int leftOver = n%7;
        int i=1;
        for(i=1; i<=totalCycles; i++) {
            for(int x = i; x<i+7; x++) {
                sum += x;
            }
        }
        
        for(int j=i; j<i+leftOver; j++) {
            sum +=j;
        }
        
        return sum;
        
        
        
        // 1, 2, 3, 4, 5, 6, 7
        // 2, 3, 4, 5, 6, 7, 8
            
        
    }
}