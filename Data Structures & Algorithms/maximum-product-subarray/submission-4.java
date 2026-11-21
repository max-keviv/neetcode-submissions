class Solution {
    
    public int maxProduct(int[] nums) {
        int maxProd = 1, minProd = 1, ans = nums[0];
        for(int i=0;i<nums.length;i++)
        {
            int prev = maxProd;
            maxProd = Math.max( nums[i], Math.max( maxProd * nums[i], minProd * nums[i] ) );
            minProd = Math.min( nums[i], Math.min( prev * nums[i], minProd * nums[i] ) );
            ans = Math.max(ans,maxProd);

        }
        return ans;
    }
}

//  nums[i]
//  positive prod * nums[i]
//  negative prod * nums[i]

// nums[i]
// positive prod * nums[i]
// negative prod * nums[i]
