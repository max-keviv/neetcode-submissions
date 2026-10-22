class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Comparator<Pair<Integer,Integer>> c = (a,b) -> b.getKey() - a.getKey();
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(c);
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            pq.add(new Pair(nums[i],i));
            if(i<k-1)
            {
                continue;
            }
            Pair<Integer,Integer> top = pq.peek();

            while(top != null && top.getValue() <= i-k ){
                pq.poll();
                top = pq.peek();
            }
            if(top != null)
            ans.add(top.getKey());
        }
        int[] ans_ = new int[ans.size()];
        for(int i=0;i<ans.size();i++)
        {
            ans_[i] = ans.get(i);
        }
        return ans_;
    }
}
