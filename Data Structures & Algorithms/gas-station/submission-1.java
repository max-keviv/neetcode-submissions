class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0, n = gas.length;
        for(int i=0;i<n;i++)
        {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(gasSum < costSum) return -1;
        int ans = 0;
        int cur_sum = 0;
        for(int i=0;i<n;i++)
        {
            cur_sum = Math.max(cur_sum + gas[i] - cost[i], gas[i] - cost[i]);
            if(cur_sum < 0) ans = i + 1;
        }
        return ans;
    }
}
