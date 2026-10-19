class Solution {
    boolean canEat(int[] piles, int k, int h)
    {
        int i = 0, j = 0, n = piles.length;
        while(i<n && j<h){
            j+=(piles[i]+k-1)/k;
            i++;
        }
        return (i==n) && (j<=h);
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0, n = piles.length;
        for(int i=0;i<n;i++)
            high = Math.max(high,piles[i]);
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            System.out.println("k = "+mid);
            System.out.println("can = "+canEat(piles,mid,h));
            if(canEat(piles,mid,h)){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}
