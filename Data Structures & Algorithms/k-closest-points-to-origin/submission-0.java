class Solution {

    public int squaredDistance(int x, int y){
        return x*x+y*y;
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((i,j)->Integer.compare(squaredDistance(points[i][0],points[i][1]),squaredDistance(points[j][0],points[j][1])));
        int ans[][] = new int[k][2];
        for(int i=0;i<points.length;i++)
        {
            heap.add(i);
        }
        int i = 0;
        while(heap.size() > 0 && i < k)
        {
            int idx = heap.poll();

            ans[i][0] = points[idx][0];
            ans[i][1] = points[idx][1];

            i++;
        }
        return ans;
    }
}
