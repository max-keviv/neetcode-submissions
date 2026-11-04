class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums,subset,ans,0,target);
        return ans;
    }
    public void backtrack(int[] nums, List<Integer> subset, List<List<Integer>> ans, int pos, int target){
        if(pos >= nums.length) return;
        if(target == 0) {
            ans.add(new ArrayList<Integer>(subset));
            return;
        }
        if(target < 0) return;
        subset.add(nums[pos]);
        backtrack(nums,subset,ans,pos,target-nums[pos]);
        subset.remove(subset.size()-1);
        backtrack(nums,subset,ans,pos+1,target);
    }
}
