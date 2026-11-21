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
    public boolean wordBreak(String str, List<String> wordDict) {
        int len = str.length();
        int cache[] = new int[len+1];
        cache[0] = 1;
        for(int j=1;j<=len;j++)
        {
            String s = str.substring(0,j);
            int l = s.length();
            for(int i=0;i<wordDict.size();i++)
            {
                String word = wordDict.get(i);
                int wordLength = word.length();
                if(l < wordLength) continue;
                String substr = s.substring(l-wordLength);
                if(substr.matches(word))
                {
                    String remainingS = s.substring(0,l-wordLength);
                    if(cache[l-wordLength] != 0) {
                        cache[l] = 1;
                        break;
                    }
                }
            }
        }
        return cache[len] == 1 ? true : false;
    }
}
