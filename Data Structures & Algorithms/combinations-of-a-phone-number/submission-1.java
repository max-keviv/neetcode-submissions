class Solution {
    
     private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public void dfs(String digits, String letter, int pos, List<String> ans)
    {
        if(pos >= digits.length()) {
            ans.add(new String(letter));
            return;
        }
        int digit = Integer.parseInt(digits.substring(pos,pos+1));
        String letters = KEYPAD[digit];
        // System.out.println(digit);
        for(int i=0;i<letters.length();i++)
        {

            letter = letter + letters.substring(i,i+1);
            dfs(digits,letter,pos+1,ans);
            letter = letter.substring(0,letter.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;
        String letter = "";
        dfs(digits,letter,0,ans);
        return ans;
    }
}
