class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int arr[] = new int[n];

        for(int i=0; i<n; i++) {
            int x = nums1[i];
            int nge = -1;
            int idx = -1;
            
            for(int j=0; j<m; j++) {
                if(nums2[j] == x) {
                    idx = j;
                    break;
                }
            }

            for(int j=idx+1; j<m; j++) {
                if(nums2[j] > x){
                    nge = nums2[j];
                    break;
                }
            }

            arr[i] = nge;
        }
        return arr;
    }
}