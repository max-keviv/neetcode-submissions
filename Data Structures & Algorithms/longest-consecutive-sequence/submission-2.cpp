class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        map<int,int> prefixCount;
        for(int i=0;i<nums.size();i++)
        {
            prefixCount[nums[i]] = prefixCount[nums[i]] + 1;
        }
        int ans = 0, cur = 1, prev = -1;
        for(auto k:prefixCount){
            if(prev + 1 != k.first)
                cur = 1;
            ans = max(ans, cur);
            prev = k.first;
            cur++;
        }
        return ans;
    }
};
