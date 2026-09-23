class Solution {
public:
    int trap(vector<int>& height) {
        int totalWaterCapacity = 0;
        stack<int> capacity;
        for(int i=0;i<height.size();i++){
            while(!capacity.empty() && height[capacity.top()] <= height[i]){
                int top = capacity.top();
                capacity.pop();
                totalWaterCapacity -= height[top];
                if(capacity.empty())
                {
                    totalWaterCapacity += height[top]*(i-top);
                }
            }
            // cout<<"i = "<<i<<" "<<totalWaterCapacity<<endl;
            capacity.push(i);
        }
        while(!capacity.empty()){
                int top = capacity.top();
                capacity.pop();
                if(!capacity.empty())
                { 
                    int i = capacity.top();
                    totalWaterCapacity -= height[top];
                    totalWaterCapacity += height[top]*(top-i);
                }
            }
            return totalWaterCapacity;
    }
};
