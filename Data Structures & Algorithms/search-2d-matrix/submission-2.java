class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length, low = 0;
        int high = n-1;
        while (low <= high){
            int mid = low + (high - low)/2;
            int i = mid, j = 0;
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) high = mid - 1;
            else low = mid + 1;
        }
        if(high < 0) return false;
        int i = high;
        low = 0;
        high = m-1;
        while (low <= high){
            int mid = low + (high - low)/2;
            int j = mid;
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
        
    }
}
// 0 11 mid=5(1,1)
// 0 5 mid = 2(0,2)
// 2 5 mid = 3(0,3)
// 3 5 mid = 4(1,0) return


