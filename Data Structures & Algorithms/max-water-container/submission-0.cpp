class Solution {
public:
    int maxArea(vector<int>& heights) {
        int size = heights.size();
        int left = 0, right = size - 1, ans = 0;
        while(left < right)
        {
            ans = max(ans,min(heights[left],heights[right]) * (right-left));
            if(heights[left] <= heights[right])
            {
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }
};
