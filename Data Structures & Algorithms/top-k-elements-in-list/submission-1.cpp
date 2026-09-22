class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        priority_queue<pair<int,int>> maxHeap;
        map<int,int> numsCount;
        vector<int> ans;
        for(int i=0;i<nums.size();i++)
        {
            numsCount[nums[i]]++;
            maxHeap.push({numsCount[nums[i]],nums[i]});
        }
        int no_of_elem = k;
        while(no_of_elem){
            pair<int,int> top = maxHeap.top();
            if(numsCount[top.second]!=-1){
                ans.push_back(top.second);
                numsCount[top.second]=-1;
                no_of_elem--;
            }
            maxHeap.pop();
        }
        return ans;
    }
};
