class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0, j=0, x=0;
        int n = nums1.length;
        int m = nums2.length;
        int median = (n+m)/2;
        int[] arr = new int[n+m];

        while(i<n && j<m) {
            if(nums1[i] < nums2[j]) {
                System.out.println(nums1[i]+" "+nums2[j]);
                arr[x] = nums1[i];
                i++;
                x++;
            }
            else {
                System.out.println("Hi "+nums2[j]);
                arr[x] = nums2[j];
                j++;
                x++;
            }
        }
        while(i<n) {
            arr[x] = nums1[i];
            i++;
            x++;
        }
        while(j<m) {
            arr[x] = nums2[j];
            j++;
            x++;
        }
        System.out.println("Median "+median);

        for(int z=0 ; z<m+n ; z++) {
            System.out.println(arr[z]);
        }

        if((n+m) % 2 ==0){
            return (arr[median-1] + arr[median])/2.0;
        }
        return arr[median];
        
        
    }
}