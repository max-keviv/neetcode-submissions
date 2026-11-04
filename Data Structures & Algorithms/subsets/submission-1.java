class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void backtracking(int[] nums, List<Integer> subsets, int i){
        List<Integer> newSubset = new ArrayList<>(subsets);
        if(i >= nums.length){ 
            ans.add(new ArrayList<>(subsets));
            return;
        }
        newSubset.add(nums[i]);
        backtracking(nums,newSubset,i+1);
        newSubset.remove(newSubset.size()-1);
        backtracking(nums,newSubset,i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        backtracking(nums,subset,0);
        return ans;
    }
}
