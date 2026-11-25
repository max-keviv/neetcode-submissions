class Solution {
    public String getSmallerString(String a, String b){
        return a == null ? b : ( b == null ? a : ( a.compareTo(b) < 0 ? a : b ));
    }
    public List<String> find(String cur, Map<String,List<String>> travelled, Map<String,List<String>> flightPath){
        
        String next = null;
        if(travelled.get(cur)!=null) return travelled.get(cur);
        List<String> ans = new ArrayList<>();
        ans.add(cur);
        List<String> flights = flightPath.getOrDefault(cur,new ArrayList<>());
        flights.sort(null);
        int mx = 0;
        List<String> correctAns = null;
        for(String flight: new ArrayList<>(flights)){
            next = flight;
            flightPath.get(cur).remove(next);
            List<String> path = find(next,travelled,flightPath);
            if(path.size() > mx){
                mx = path.size();
                correctAns = new ArrayList<>(path);
            }
            flightPath.get(cur).add(next);
        }
        if(correctAns != null)
        for(String a:correctAns)
        ans.add(a);
        travelled.put(cur,ans);
        return ans;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> flightPath = new HashMap<>();
        for(List<String> ticket:tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            flightPath.computeIfAbsent(from,k -> new ArrayList<>()).add(to);
        }
        // List<String> ans = new ArrayList<>();
        // Queue<String> dfs = new ArrayDeque<>();
        // dfs.add("JFK");
        // while(!dfs.isEmpty()){
        //     String cur = dfs.poll();
        //     ans.add(cur);
        //     String next = null;
        //     for(String flight: flightPath.getOrDefault(cur,new ArrayList<>())){
        //         next = getSmallerString(next,flight);
        //     }
        //     if(next != null) {
        //         flightPath.get(cur).remove(next);
        //         dfs.add(next);
        //     }
        // }
        return find("JFK",new HashMap<>(),flightPath);
    }
}
