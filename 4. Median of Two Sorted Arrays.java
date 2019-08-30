// Left side all <=  
// right side all > 
// total length = m + n 
// find i,j -> i + j = (m + n + 1) / 2
//      i, j may occur in same array
//
// 1) m[i] > n[j + 1] -> too large, shift left
// 2) m[i] < n[j - 1] -> too small, shift right
// 3)  m[i] <= n[j + 1] && m[i] >= n[j - 1] -> right position || i < 0 || i == m  || i not exist in m
//      find leftMax: 1) i = 0 -> n[j - 1], 2) j = 0 -> m[i - 1] 3) else: max(m[i - 1], n[j - 1])
//      rightMin: similar
//      => odd: return leftMax
//      => even: return (leftMax + rightMin) / 2 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length, n = nums2.length, iMin = 0, iMax = m; 
        while(iMin <= iMax){
            int i = (iMin + iMax) / 2, j = (m + n + 1) / 2 - i; // i, j are not index, are length,number
            if(i > iMin && nums1[i - 1] > nums2[j]){ // m[i] too large
                iMax = i - 1;
            } else if(i < iMax && nums1[i] < nums2[j - 1]){ // m[i] too small
                iMin = i + 1;
            } else{ // i, j at right position
                int leftMax;
                if(j == 0){
                    leftMax = nums1[i - 1];
                } else if(i == 0){
                    leftMax = nums2[j - 1];
                } else {
                    leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if((m + n) % 2 == 1){
                    return leftMax;
                }
                
                int rightMin;
                if(j == n){
                    rightMin = nums1[i];
                } else if(i == m){
                    rightMin = nums2[j];
                } else{
                    rightMin = Math.min(nums1[i], nums2[j]);
                }
                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0.0;
    }
}