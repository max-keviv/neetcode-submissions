class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        int cooldown[] = new int[26];
        for(int i=0;i<tasks.length;i++)
            freq[tasks[i]-'A']++;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (freq[b] - freq[a]));
        PriorityQueue<Integer> cooldownHeap = new PriorityQueue<>((a,b) -> (cooldown[a] - cooldown[b]));

        for(int i=0;i<26;i++)
        {
            if(freq[i] > 0) maxHeap.add(i);
        }
        int counter = 1;
        while(maxHeap.size() > 0 || cooldownHeap.size() > 0)
        {
            if(cooldownHeap.size() > 0 && cooldown[cooldownHeap.peek()] < counter){
                int task = cooldownHeap.poll();
                maxHeap.add(task);
            }
            if(maxHeap.size() > 0)
            {
                int task = maxHeap.poll();
                if(--freq[task] > 0){
                    cooldown[task] = counter + n;
                    cooldownHeap.add(task);
                }
            }
            counter++;
        }
        return counter-1;
    }
}

// X X X Y Y Y Z Z

// X Y X Y X Y Z Z

// X Z X Y X Y X Z X Y

// X -> 5
// Y -> 3
// Z -> 2

// t = 2


// freq -> 

// X    Y   Z
// 1       1

// cooldown ->  

// X    Y   Z
// 8    7   9

// X Y X Y X Y X Z Y X Z


//  X X X Y Y Y Z Z Z

// 5 4 3 2 
// A B C D



