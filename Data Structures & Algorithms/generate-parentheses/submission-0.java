class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String parentheses = "";
        backtracking(n,0,0, parentheses, ans);
        return ans;
    }
    public void backtracking(int n, int left, int right, String parentheses, List<String> ans){
        if(left > n || left < right ) return;
        if(left == n && right == n) {
            ans.add(new String(parentheses));
            return;
        }
        backtracking(n,left+1,right,parentheses+"(",ans);
        backtracking(n,left,right+1,parentheses+")",ans);
    }
}
