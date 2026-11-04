class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums); 

        backtrack(nums,0,ans,subset);
        return ans;
    }
    public void backtrack(int[] nums, int j, List<List<Integer>> ans, List<Integer> subset) {
        if(j >= nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[j]);
        backtrack(nums,j+1,ans,subset);
        subset.remove(subset.size()-1);
        while(j < nums.length - 1 && nums[j] == nums[j+1])
        j++;
        backtrack(nums,j+1,ans,subset);
    }
}
