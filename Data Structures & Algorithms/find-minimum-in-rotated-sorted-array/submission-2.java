class Solution {
    public int findMin(int[] nums) {
        int high = nums.length-1;
        int low = 0;
        while(low<=high){
            int mid = low + (high - low)/2;
            if( nums[mid] <= nums[nums.length-1] ){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
