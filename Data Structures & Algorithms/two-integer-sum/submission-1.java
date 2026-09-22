class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> targetPairIndex = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(targetPairIndex.containsKey(target-nums[i])) return new int[] {targetPairIndex.get(target-nums[i]),i};
            targetPairIndex.put(nums[i],i);
        }
        return new int[] {0,0};
    }
}
