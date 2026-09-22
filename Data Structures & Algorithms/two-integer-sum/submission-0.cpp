class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> targetPairIndex;
        for(int i=0;i<nums.size();i++)
        {
            if(targetPairIndex.contains(target-nums[i])) return {targetPairIndex[target-nums[i]],i};
            targetPairIndex[nums[i]]=i;
        }
        return {0,0};
    }
};
