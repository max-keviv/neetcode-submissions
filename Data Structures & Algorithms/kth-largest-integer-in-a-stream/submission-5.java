class KthLargest {

    int heap[];
    int n;
    int k;

    public KthLargest(int k, int[] nums) {
        n = 0;
        this.k=k;
        heap = new int[k];
        for(int i=0;i<nums.length;i++)
        {
            if(n < k){
                heap[n] = nums[n];
                shiftUp(n++);
            } else if( nums[i] > heap[0]) {
                heap[0] = nums[i];
                shiftDown(0);
            }
        }
    }
    
    public int add(int val) {
        if(n < k){
            heap[n] = val;
            shiftUp(n++);
        }
        else if(heap[0] < val){
            heap[0] = val;
            shiftDown(0);
        }
        return heap[0];
    }
    public void shiftUp(int i){
        while(i > 0){
            int par = (i-1)/2;
            if(heap[par] < heap[i]) break;
            int tmp = heap[par];
            heap[par] = heap[i];
            heap[i] = tmp;
            i = par;
        }
    }
    public void shiftDown(int i){

        while(i<n){
            int left = 2*i + 1;
            int right = 2*i + 2;
            int smallest = i;
            if(left < n && heap[left] < heap[smallest]) smallest = left;
            if(right < n && heap[right] < heap[smallest]) smallest = right;
            if(smallest == i) break;
            int tmp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = tmp;
            i = smallest;
        }
    }
}
