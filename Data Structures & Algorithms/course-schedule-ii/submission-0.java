class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int inDegree[] = new int[numCourses];
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(v).add(u);
            inDegree[u]++;
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        int finished = 0;
        for(int i=0;i<numCourses;i++)
        {
            if(inDegree[i]==0) queue.add(i);
        }
        int ans[] = new int[numCourses];
        while(!queue.isEmpty()){
            int course = queue.poll();
            ans[finished] = course;
            finished++;
            for(int nextCourses: graph.get(course))
            {
                inDegree[nextCourses]--;
                if(inDegree[nextCourses] == 0) queue.add(nextCourses);
            }
        }
        if(numCourses == finished) return ans;
        return new int[0];
    }
}
