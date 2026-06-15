package com.socialmedia.feed;

import com.socialmedia.model.Post;
import com.socialmedia.model.User;

import java.util.List;

public interface FeedStrategy {

    List<Post> getFeed(User user);
}