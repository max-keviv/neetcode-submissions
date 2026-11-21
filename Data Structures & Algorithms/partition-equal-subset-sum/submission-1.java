class Solution {
    public boolean equalPartition(int pos, int currentSum,int targetSum, int[] nums, int[][] cache){
        if(pos>=nums.length) return currentSum == targetSum;
        if(cache[pos][currentSum] != 0) return cache[pos][currentSum] == 1 ? true : false;
        cache[pos][currentSum] = equalPartition(pos+1,currentSum+nums[pos],targetSum,nums,cache) || equalPartition(pos+1,currentSum,targetSum,nums,cache) ? 1 : -1;
        return cache[pos][currentSum] == 1 ? true : false;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;
        for(int i=0;i<n;i++)
            sum+=nums[i];
        if(sum%2!=0) return false;
        int cache[][] = new int[n+1][sum+1];
        return equalPartition(0,0,sum/2,nums,cache);
    }
}

// [1,2,3,4]
//  [1][]                [][1]
//[1,2][] [1][2]   [2][1]   [][1,2]   