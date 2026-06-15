package com.socialmedia;

import com.socialmedia.enums.PostVisibility;
import com.socialmedia.facade.SocialMediaFacade;
import com.socialmedia.model.Post;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Social Media System =====\n");

        // Create facade
        SocialMediaFacade socialMedia = new SocialMediaFacade();

        // Create users
        System.out.println("--- Creating Users ---");
        socialMedia.createUser("user1", "Alice", "alice@email.com");
        socialMedia.createUser("user2", "Bob", "bob@email.com");
        socialMedia.createUser("user3", "Charlie", "charlie@email.com");
        System.out.println();

        // Users follow each other
        System.out.println("--- Following Operations ---");
        socialMedia.followUser("user1", "user2");
        socialMedia.followUser("user2", "user1");
        socialMedia.followUser("user2", "user3");
        System.out.println();

        // Create posts
        System.out.println("--- Creating Posts ---");
        Post post1 = socialMedia.createPost("user1", "Beautiful sunset today!", PostVisibility.PUBLIC);
        Post post2 = socialMedia.createPost("user2", "Just finished a great workout!", PostVisibility.FRIENDS_ONLY);
        Post post3 = socialMedia.createPost("user3", "Coffee time!", PostVisibility.PUBLIC);
        System.out.println();

        // Like posts
        System.out.println("--- Liking Posts ---");
        socialMedia.likePost("user2", post1.getPostId());
        socialMedia.likePost("user3", post1.getPostId());
        socialMedia.likePost("user1", post2.getPostId());
        System.out.println();

        // Add comments
        System.out.println("--- Adding Comments ---");
        socialMedia.addComment("user2", post1.getPostId(), "This looks amazing!");
        socialMedia.addComment("user3", post1.getPostId(), "Wow, breathtaking!");
        socialMedia.addComment("user2", post3.getPostId(), "Enjoy your coffee!");
        System.out.println();

        // View posts
        System.out.println("--- Viewing Posts Feed ---");
        socialMedia.viewPostFeed(post1.getPostId());
        System.out.println();
        socialMedia.viewPostFeed(post2.getPostId());
        System.out.println();
        socialMedia.viewPostFeed(post3.getPostId());
        System.out.println();

        // Unlike post
        System.out.println("--- Unlike Post ---");
        socialMedia.unlikePost("user2", post1.getPostId());
        System.out.println();

        // View updated post
        System.out.println("--- Updated Post Feed ---");
        socialMedia.viewPostFeed(post1.getPostId());
    }
}

