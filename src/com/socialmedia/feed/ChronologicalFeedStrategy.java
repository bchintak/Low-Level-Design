package com.socialmedia.feed;

import com.socialmedia.model.Post;
import com.socialmedia.model.User;

import java.util.Comparator;
import java.util.List;

public class ChronologicalFeedStrategy
        implements FeedStrategy {

    @Override
    public List<Post> getFeed(User user) {

        return user.getFollowing()
                .stream()
                .flatMap(u -> u.getPosts().stream())
                .sorted(
                        Comparator.comparing(
                                Post::getCreatedAt
                        ).reversed()
                )
                .toList();
    }
}