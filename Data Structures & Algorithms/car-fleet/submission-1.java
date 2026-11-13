class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> timing = new Stack<Double>();
        List<Pair<Integer,Integer>> cars = new ArrayList<Pair<Integer,Integer>>();
        for(int i=0;i<position.length;i++)
        {
            cars.add(new Pair<>(position[i],speed[i]));
        }
        cars.sort((a,b)->(Integer.compare(a.getKey(),b.getKey())));
        for(int i=0;i<cars.size();i++)
        {
            double time = (double)(target-cars.get(i).getKey())/(double)cars.get(i).getValue();
            while(timing.size() > 0 && timing.peek() <= time)
            {
                timing.pop();
            }
            timing.push(time);
            // System.out.println(timing);
        }
        return timing.size();
    }
}
