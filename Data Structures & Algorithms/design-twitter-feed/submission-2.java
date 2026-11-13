class Twitter {

    public Map<Integer, PriorityQueue<Integer>> feeds;
    public Map<Integer, Set<Integer>> followers;
    public Map<Integer, Integer> tweets;
    public Map<Integer, Integer> tweetsToUser;
    public Map<Integer, List<Integer>> userToTweets;
    
    public Integer counter = 0;
    public Twitter() {
        feeds = new HashMap<>();
        followers = new HashMap<>();
        tweets = new HashMap<>();
        tweetsToUser = new HashMap<>();
        userToTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {

        Set<Integer> userfollowers = followers.get(userId);
        if(userfollowers == null){
            userfollowers = new HashSet<>();
            userfollowers.add(userId);
            followers.put(userId,userfollowers);
            userfollowers.add(userId);
        }
        if(userToTweets.get(userId) == null)
        {
            List<Integer> userTweets = new ArrayList<Integer>();
            userTweets.add(tweetId);
            userToTweets.put(userId,userTweets);
        } else {
            List<Integer> userTweets = userToTweets.get(userId);
            userTweets.add(tweetId);
        }

        tweetsToUser.put(tweetId,userId);
        tweets.put(tweetId,counter);
        
        for(Integer follower: userfollowers){
            if(feeds.get(follower) == null) {
                PriorityQueue<Integer> latestTweets = new PriorityQueue<Integer>((a,b) -> (Integer.compare(tweets.get(b), tweets.get(a))));
                latestTweets.add(tweetId);
                feeds.put(follower,latestTweets);
            } else {
                PriorityQueue<Integer> latestTweets = feeds.get(follower);
                latestTweets.add(tweetId);
            }
        
        }
        // System.out.println("followers " + followers);
        // System.out.println("tweets " + tweets);
        // System.out.println("feeds " + feeds);
        // System.out.println("tweetsToUser "+ tweetsToUser);
        // System.out.println("userToTweets " + userToTweets);
        // System.out.println("");
        counter++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // get user feed for each tweet check if user is still following this user or not repeat till 10 
        PriorityQueue<Integer> userFeed = feeds.get(userId);
        List<Integer> userFeeds = new ArrayList<Integer>();
        if(userFeed == null ) return userFeeds;
        PriorityQueue<Integer> feed = new PriorityQueue<Integer>(userFeed);
        Set<Integer> follower = followers.get(userId);

        Map<Integer,Boolean> duplicate = new HashMap<>();
        
        while(feed.size() > 0 && userFeeds.size() < 10)
        {
            Integer tweet = feed.poll();
            Integer userTweet = tweetsToUser.get(tweet);
            Set<Integer> followee = followers.get(userTweet);
            if(((followee != null && followee.contains(userId)) || userTweet == userId) && !duplicate.getOrDefault(tweet,false)) {
                duplicate.put(tweet,true);
                userFeeds.add(tweet);
            }
        }
        // System.out.println("followers " + followers);
        // System.out.println("tweets " + tweets);
        // System.out.println("feeds " + feeds);
        // System.out.println("tweetsToUser "+ tweetsToUser);
        // System.out.println("userToTweets " + userToTweets);
        // System.out.println("");
        return userFeeds;
    }
    
    public void follow(int followerId, int followeeId) {
        // add the follower to followee list
        Set<Integer> userFollower =
        followers.computeIfAbsent(followeeId, k -> new HashSet<>());
        if(userFollower.contains(followerId)) return;
        if(followers.get(followeeId) != null)
        {  
            Set<Integer> userFollowers = followers.get(followeeId);
            userFollowers.add(followerId);
        } else {
            Set<Integer> userFollowers = new HashSet<>();
            userFollowers.add(followerId);
            followers.put(followeeId, userFollowers);
        }
        List<Integer> userTweets = userToTweets.getOrDefault(followeeId, new ArrayList<>());
        // System.out.println("userTweets " + userTweets);
        PriorityQueue<Integer> latestTweets;
        if(feeds.get(followerId) == null) {
            latestTweets = new PriorityQueue<Integer>((tweet1,tweet2) -> (tweets.getOrDefault(tweet2,0) - tweets.getOrDefault(tweet1,0)));
            feeds.put(followerId,latestTweets);
            // System.out.println("followerId " + followerId +" latestTweets "+latestTweets);
        } else {
            latestTweets = feeds.get(followerId);
            // System.out.println("followerId " + followerId +" latestTweets "+latestTweets);
        }
        for(Integer tweets: userTweets)
        {
            latestTweets.add(tweets);
        }
        //  System.out.println("followers " + followers);
        // System.out.println("tweets " + tweets);
        // System.out.println("feeds " + feeds);
        // System.out.println("tweetsToUser "+ tweetsToUser);
        // System.out.println("userToTweets " + userToTweets);

        // System.out.println("latestTweets " + latestTweets);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        // remove the follower from the followee list
         if(followers.get(followeeId) != null)
        {  
            Set<Integer> follower = followers.get(followeeId);
            follower.remove(followerId);
        }

        // System.out.println("followers " + followers);
        // System.out.println("tweets " + tweets);
        // System.out.println("feeds " + feeds);
        // System.out.println("tweetsToUser "+ tweetsToUser);
        // System.out.println("userToTweets " + userToTweets);
        // System.out.println("");
    }
}
