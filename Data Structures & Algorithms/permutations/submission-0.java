class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        List<Integer> permutations = new ArrayList<>();
        backtrack(nums,ans, permutations, pick);
        return ans;
    }
    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> permutations, boolean[] pick){
        if(permutations.size() == nums.length) {
            ans.add(new ArrayList<>(permutations));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(pick[i] == false){
                pick[i] = true;
                permutations.add(nums[i]);
                backtrack(nums,ans,permutations,pick);
                pick[i] = false;
                permutations.remove(permutations.size()-1);
            }
        }
    }
}
