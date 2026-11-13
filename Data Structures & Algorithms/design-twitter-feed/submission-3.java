class Twitter {

    public Map<Integer, Set<Integer>> followerMap;
    public Map<Integer, List<Pair<Integer,Integer>>> userTweetMap;
    public Integer timer = 0;
    public Twitter() {
        followerMap = new HashMap<>();
        userTweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Pair<Integer,Integer> p = new Pair<Integer,Integer>(timer,tweetId);
        List<Pair<Integer,Integer>> user = userTweetMap.get(userId);
        if(user == null) {
            user = new ArrayList<>();
            userTweetMap.put(userId,user);
        }
        user.add(p);
        if(user.size() > 10) user.remove(0);
        timer++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair<Integer,Integer>> maxHeap = new PriorityQueue<Pair<Integer,Integer>>((a,b) -> Integer.compare(b.getKey(),a.getKey()));

        List<Pair<Integer,Integer>> tweet = userTweetMap.get(userId);
        if(tweet != null)
            for(int i=0;i<tweet.size();i++)
            {
                maxHeap.add(tweet.get(i));
            }

        Set<Integer> followers = followerMap.get(userId);
        if(followers != null)
        {
            for(Integer follower: followers)
            {
                List<Pair<Integer,Integer>> followerTweet = userTweetMap.get(follower);
                if(followerTweet != null)
                    for(int i=0;i<followerTweet.size();i++)
                    {
                        maxHeap.add(followerTweet.get(i));
                    }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(maxHeap.size() > 0 && ans.size() < 10)
        {
            ans.add(maxHeap.poll().getValue());
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followers = followerMap.get(followerId);
        if(followers == null)
        {
            followers = new HashSet<Integer>();
            followerMap.put(followerId,followers);
        }
        followers.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followers = followerMap.get(followerId);
        if(followers == null) return;
        followers.remove(followeeId);
    }
}
