class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
        {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int n = nums1.length, m = nums2.length;
        int k = (n+m+1)/2;
        int low = 0, high = n;

        while(low <= high)
        {
            int i = low + (high - low)/2;
            int j = k - i;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            l1 = i == 0 ? l1 : nums1[i-1];
            l2 = j == 0 ? l2 : nums2[j-1];
            r1 = i == n ? r1 : nums1[i];
            r2 = j == m ? r2 : nums2[j];
            if((l1<=r2)&&(l2<=r1)){
                if((n+m)%2==0){
                    return (((double)Math.max(l1,l2)) + ((double)Math.min(r1,r2))) / 2.0;
                }
                else return (double)Math.max(l1,l2);
            }
            else if(l1>r2) high = i - 1;
            else low = i + 1;
        }
        return 0;
    }
}
