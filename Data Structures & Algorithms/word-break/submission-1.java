class Solution {
    public boolean canSplit(String s, List<String> wordDict, int[] cache)
    {
        if(s.matches("")) return true;
        int l = s.length();
        if(cache[l] != 0 ) return cache[l] == -1 ? false : true;
        for(int i=0;i<wordDict.size();i++)
        {
            String word = wordDict.get(i);
            int wordLength = word.length();
            if(l < wordLength) continue;
            String str = s.substring(0,wordLength);
            if(str.matches(word))
            {
                String remainingS = s.substring(wordLength);
                if(canSplit(remainingS, wordDict, cache)) {
                    cache[l] = 1;
                    return true;
                }
            }
        }
        cache[l] = -1;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {

        int cache[] = new int[s.length()+1];
        return canSplit(s,wordDict,cache);
    }
}
