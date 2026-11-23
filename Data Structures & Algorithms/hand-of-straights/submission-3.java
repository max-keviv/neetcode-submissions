class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0) return false;
        Map<Integer,Integer> count = new HashMap<>();
        for(int i=0;i<hand.length;i++)
        {
            count.put(hand[i],count.getOrDefault(hand[i],0)+1);
        }
        Arrays.sort(hand);
        for(int num: hand)
        {
            if(count.get(num) > 0)
            {
                for(int j=num;j<num+groupSize;j++)
                {
                    if(count.getOrDefault(j,0) == 0) return false;
                    count.put(j,count.get(j)-1);
                }
            }
        }
        return true;
    }
}

// 