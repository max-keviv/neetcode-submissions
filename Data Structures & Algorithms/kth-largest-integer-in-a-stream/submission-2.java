class KthLargest {
    public final List<Integer> heap;
    int size;
    public void sort(int j){
        while(j>0){
            int par = j/2;
            if(heap.get(par) < heap.get(j)) break;
            int tmp = heap.get(par);
            heap.set(par,heap.get(j));
            heap.set(j,tmp);
            j = j/2;
        }
    }
    public void heapify(){
        for(int i=0;i<heap.size();i++)
        {
            sort(i);
        }
    }
    public KthLargest(int k, int[] nums) {
        int i=0;
        size = k;
        heap = new ArrayList<>();
        while(i<nums.length)
        {
            heap.add(nums[i]);
            int j = heap.size()-1;
            sort(j);
            if(heap.size() > k)
            {
                heap.remove(0);
                heapify();
            }
            i++;
        }
        System.out.print(heap);
    }
    
    public int add(int val) {
        heap.add(val);
        sort(heap.size()-1);
        if(heap.size() > size)
        {
            heap.remove(0);
            // System.out.print(heap);
            heapify();
        }
        return heap.get(0);
    }
}

        // 1
//     2       3
// 3      4 5     6