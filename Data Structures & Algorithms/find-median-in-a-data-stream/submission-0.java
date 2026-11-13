class MedianFinder {

    public PriorityQueue<Integer> firstHalfMaxHeap;
    public PriorityQueue<Integer> secondHalfMinHeap;
    int size = 0;
    public MedianFinder() {
        firstHalfMaxHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));
        secondHalfMinHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(firstHalfMaxHeap.size() == 0 || firstHalfMaxHeap.peek() > num ){
            firstHalfMaxHeap.add(num);
        } else {
            secondHalfMinHeap.add(num);
        }
        while(firstHalfMaxHeap.size() < secondHalfMinHeap.size()){
            firstHalfMaxHeap.add(secondHalfMinHeap.poll());
        }
        while(firstHalfMaxHeap.size() - 1 > secondHalfMinHeap.size()){
            secondHalfMinHeap.add(firstHalfMaxHeap.poll());
        }
    }
    
    public double findMedian() {
        if((firstHalfMaxHeap.size()+secondHalfMinHeap.size())%2 == 0) return ((double)firstHalfMaxHeap.peek()+secondHalfMinHeap.peek())/2.0;
        else return firstHalfMaxHeap.peek();

    }
}

