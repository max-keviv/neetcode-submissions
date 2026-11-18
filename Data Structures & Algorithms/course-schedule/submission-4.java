class Solution {
    public boolean dfs(int u, boolean[] visited, boolean[] completed, List<List<Integer>> graph){
        List<Integer> adjCourses = graph.get(u);

        visited[u] = true;
        for(int i=0;i<adjCourses.size();i++)
        {
            int v = adjCourses.get(i);
            if(!completed[u] && (visited[v] || dfs(v,visited,completed,graph))) return true;
        }
        visited[u] = false;
        completed[u] = true;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        boolean completed[] = new boolean[numCourses];
        for(int i=0;i<prerequisites.length;i++)
        {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            if(graph.get(u)==null)
            {
                graph.set(u,new ArrayList<Integer>());
            }
            graph.get(u).add(v);
        }
        for(int i=0;i<numCourses;i++)
        {
            if(!completed[i]) {
                if(dfs(i,new boolean[numCourses],completed,graph)) return false;
            }
        }
        return true;
    }
}


