class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int mx = 0;
        int cur = 0;
        while(cur < n && cur <= mx){
            mx = Math.max(cur+nums[cur],mx);
            cur++;
        }
        if(mx >= n-1) return true;
        return false;
    }
}
