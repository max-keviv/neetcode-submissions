class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
        for(int i=0;i<nums.length;i++)
        {
            heap.add(nums[i]);
        }
        while(--k > 0)
        {
            heap.poll();
        }
        return heap.poll();
    }
}
