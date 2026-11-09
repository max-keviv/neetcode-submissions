class Solution {
    public boolean isPalindrome(String s){
        int n = s.length();
        int i = 0;
        while(i<n/2){
            if(s.charAt(i) != s.charAt(n-i-1)){
                return false;
            }
            i++;
        }
        return true;

    }
    public void backtracking(String s, int pos, List<String> palindromes, List<List<String>> ans){
        if(pos >= s.length())
        {
            ans.add(new ArrayList<>(palindromes));
            return;
        }
        for(int i=pos;i<s.length();i++)
        {
            String str = s.substring(pos,i+1);
            if(isPalindrome(str) == false)
            continue;
            palindromes.add(s.substring(pos,i+1));
            backtracking(s,i+1,palindromes,ans);
            palindromes.remove(palindromes.size()-1);
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> palindrome = new ArrayList<>();
        backtracking(s,0,palindrome,ans);
        return ans;
    }
}
