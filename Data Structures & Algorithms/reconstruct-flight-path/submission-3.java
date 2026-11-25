class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Stack<String> stack = new Stack<>();
        List<String> ans = new ArrayList<>();
        Map<String,List<String>> adjGraph = new HashMap<>();
        tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));
        for(List<String> ticket:tickets)
        {
            adjGraph.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
        }
        stack.push("JFK");
        while(!stack.isEmpty()){
            String curr = stack.peek();
            if(adjGraph.get(curr) == null || adjGraph.get(curr).size() == 0)
            {
                ans.add(stack.pop());
                continue;
            }
            List<String> edges = new ArrayList<>(adjGraph.get(curr));
           
            stack.push(edges.get(0));
            adjGraph.get(curr).remove(edges.get(0));

        }
        Collections.reverse(ans);
        return ans;
    }
}


