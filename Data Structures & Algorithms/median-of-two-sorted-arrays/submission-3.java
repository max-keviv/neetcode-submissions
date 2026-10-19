class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int n = nums1.length;
        int m = nums2.length;
        int k = (n + m + 1) / 2;

        int low = 0, high = n;

        while (low <= high) {
            int j = k - low;

            int left1 = low == 0 ? Integer.MIN_VALUE : nums1[low - 1];
            int right1 = low == n ? Integer.MAX_VALUE : nums1[low];

            int left2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = j == m ? Integer.MAX_VALUE : nums2[j];

            if (left1 <= right2 && left2 <= right1) {
                if ((n + m) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                return ((double) Math.max(left1, left2)
                        + Math.min(right1, right2)) / 2.0;
            }

            low++;
        }

        throw new IllegalArgumentException("Input arrays must be sorted");
    }
}