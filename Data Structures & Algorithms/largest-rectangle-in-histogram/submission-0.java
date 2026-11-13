class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> minHeight = new Stack<>();
        int ans = 0;
        int n = heights.length;
        for(int i=0;i<heights.length;i++)
        {
            while(minHeight.size() != 0 && heights[minHeight.peek()] > heights[i] ){
                int curr = minHeight.peek();
                minHeight.pop();
                int prev = minHeight.isEmpty() ? -1 : minHeight.peek() ;
                int area = heights[curr] * (i - 1 - prev);
                ans = Math.max(ans,area);
            }
            minHeight.push(i);
        }
        while(minHeight.size() != 0){
                int curr = minHeight.peek();
                minHeight.pop();
                int prev = minHeight.isEmpty() ? -1 : minHeight.peek() ;
                int area = heights[curr] * (n - 1 - prev);
                ans = Math.max(ans,area);
            }
            return ans;
    }
}
// stack for min heights till now
// for each height in heights
// while current height is less than or equal peek of stack keep removing the stack till not empty
// then calculate height as current height * distance from current height to peek of element in stack 
// end loop

// while the stack is not empty
// we know that if this element is in stack then this is lowest height between end to prev height