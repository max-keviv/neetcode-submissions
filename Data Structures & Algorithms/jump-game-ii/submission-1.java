class Solution {
    public int jump(int[] nums) {
        int l = 0, r = 0, fartest = 0, jumps =0, n = nums.length;
        while(r<n-1)
        {
            for(int i=l;i<=r;i++)
            {
                fartest = Math.max(fartest,i+nums[i]);
            }
            l++;
            r = fartest;
            jumps++;
        }
        return jumps;
    }
}
