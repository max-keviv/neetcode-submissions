class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean flag[] = new boolean[3];
        int n = triplets.length;
        for(int i=0;i<n;i++)
        {
            boolean valid = true;
            for(int j=0;j<3;j++){
                valid = valid && (target[j] >= triplets[i][j]);
            }
            if(valid){
                for(int j=0;j<3;j++){
                    flag[j] = flag[j] || (target[j] == triplets[i][j]);
                }
            }
        }
        return flag[0] && flag[1] && flag[2];
    }
}


// [8,5,3]

// [9, 1, 3]
// []