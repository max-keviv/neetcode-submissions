class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void backtracking(int[] nums, List<Integer> subsets, int i){
        List<Integer> newSubset = new ArrayList<>(subsets);
        if(i >= nums.length){ 
            ans.add(newSubset);
            return;
        }
        for(int j=i;j<nums.length;j++)
        {
            newSubset.add(nums[j]);
            backtracking(nums,newSubset,j+1);
            newSubset.remove(newSubset.size()-1);
        }
        ans.add(newSubset);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        backtracking(nums,subset,0);
        return ans;
    }
}
