class Solution {
    public boolean equalPartition(int subset1, int subset2, int pos, int[] nums, int[][] cache){
        if(pos>=nums.length) return subset1 == subset2;
        if(cache[subset1][subset2] != 0) return cache[subset1][subset2] == 1 ? true : false;
        cache[subset1][subset2] = equalPartition(subset1+nums[pos],subset2,pos+1,nums,cache) || equalPartition(subset1,subset2+nums[pos],pos+1,nums,cache) ? 1 : -1;
        return cache[subset1][subset2] == 1 ? true : false;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;
        for(int i=0;i<n;i++)
            sum+=nums[i];
        int cache[][] = new int[sum+1][sum+1];
        return equalPartition(0,0,0,nums,cache);
    }
}

// [1,2,3,4]
//  [1][]                [][1]
//[1,2][] [1][2]   [2][1]   [][1,2]   