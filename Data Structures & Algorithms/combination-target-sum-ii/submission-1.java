class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(candidates, target, 0, ans, subset);
        return ans;
    }
    public void dfs(int[] candidates, int target, int pos, List<List<Integer>> ans, List<Integer> subset ) {
        if(target == 0){
             ans.add(new ArrayList<Integer>(subset));
             return;
        }
        if(pos >= candidates.length || target < 0) return;
        if(pos > 0 && candidates[pos-1] == candidates[pos]){ 
            dfs(candidates,target,pos+1,ans,subset);
            return;
        }
        dfs(candidates,target,pos+1,ans,subset);
        subset.add(candidates[pos]);
        List<Integer> newSubset = new ArrayList<>(subset);
        while(pos < candidates.length - 1 && candidates[pos] == candidates[pos+1]){
            dfs(candidates,target-candidates[pos],pos+1,ans,newSubset);
            newSubset.add(candidates[pos+1]);
            target -= candidates[pos];
            pos++;
            // pos++;
        }
        dfs(candidates,target-candidates[pos],pos+1,ans,newSubset);
        subset.remove(subset.size()-1);
    }
}
