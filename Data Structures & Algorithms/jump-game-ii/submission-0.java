class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int minJump[] = new int[n];
        for(int i=0;i<n;i++)
        {
            if(i!=0 && minJump[i] == 0) continue;
            for(int j=1;j<=nums[i];j++)
            {
                if(i+j >= n) break;
                if(minJump[i+j] == 0){
                    minJump[i+j] = minJump[i] + 1;

                // System.out.println((i+j) + " " + minJump[i+j]);
                    continue;
                }
                minJump[i+j] = Math.min(minJump[i+j],minJump[i]+1);
                // System.out.println((i+j) + " " + minJump[i+j]);
            }
        }
        return minJump[n-1];
    }
}
