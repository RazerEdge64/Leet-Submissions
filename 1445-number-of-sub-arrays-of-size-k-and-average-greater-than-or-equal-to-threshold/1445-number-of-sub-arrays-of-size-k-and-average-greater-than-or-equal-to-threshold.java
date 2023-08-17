class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // int result = 0;
        // for(int i=0 ; i+k<=arr.length ; i++) {
        //     // String num = "";
        //     int avg = 0;
            
        //     for(int j = i ; j<i+k && j<arr.length ; j++) {
        //         System.out.print(arr[j]);
        //         // num+=arr[j];
        //         avg+=arr[j];
        //     }
        //     System.out.println();
        //     avg = avg/k;
        //     // int n = Integer.parseInt(num);
        //     if(avg >= threshold) {
        //         System.out.println("Avg - " + avg);
        //         result++;
        //     }
        // }
        
        // return result;

        int[] result = new int[arr.length-k+1];

        int windowStart = 0;
        int windowSum = 0;
        for(int windowEnd = 0; windowEnd<arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            if(windowEnd >= k-1) {
                result[windowStart] = windowSum / k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        int ans = 0;
        for(int i=0; i<result.length; i++) {
            if(result[i] >= threshold) ans ++;
        }

        return ans;
    }
}