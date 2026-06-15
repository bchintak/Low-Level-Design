package com.socialmedia.service;

import com.socialmedia.model.User;
import com.socialmedia.model.Post;
import com.socialmedia.model.Like;
import com.socialmedia.model.Comment;
import com.socialmedia.enums.PostVisibility;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PostService {
    private Map<String, Post> posts;
    private int likeCounter;
    private int commentCounter;

    public PostService() {
        this.posts = new HashMap<>();
        this.likeCounter = 0;
        this.commentCounter = 0;
    }

    public Post createPost(User author, String content, PostVisibility visibility) {
        if (author == null || content == null || visibility == null) {
            throw new IllegalArgumentException("Author, content, and visibility cannot be null");
        }
        String postId = "POST_" + UUID.randomUUID();
        Post post = new Post(postId, author, content, visibility);
        posts.put(postId, post);
        author.addPost(post);
        System.out.println("Post " + postId + " created by " + author.getUsername());
        return post;
    }

    public Post getPostById(String postId) {
        return posts.get(postId);
    }

    public void deletePost(String postId) {
        Post post = posts.remove(postId);
        if (post != null) {
            System.out.println("Post " + postId + " deleted successfully");
        }
    }

    public void likePost(User user, Post post) {
        String likeId = "LIKE_" + (++likeCounter);
        Like like = new Like(likeId, user, post);
        post.addLike(like);
        System.out.println(user.getUsername() + " liked the post " + post.getPostId());
    }

    public void unlikePost(User user, Post post) {
        Like likeToRemove = post.getLikes().stream()
                .filter(like -> like.getUser().equals(user))
                .findFirst()
                .orElse(null);
        if (likeToRemove != null) {
            post.removeLike(likeToRemove);
            System.out.println(user.getUsername() + " unliked the post " + post.getPostId());
        }
    }

    public Comment addComment(User author, Post post, String content) {
        String commentId = "COMMENT_" + (++commentCounter);
        Comment comment = new Comment(commentId, author, post, content);
        post.addComment(comment);
        System.out.println(author.getUsername() + " commented on post " + post.getPostId());
        return comment;
    }

    public void removeComment(Post post, String commentId) {
        Comment commentToRemove = post.getComments().stream()
                .filter(comment -> comment.getCommentId().equals(commentId))
                .findFirst()
                .orElse(null);
        if (commentToRemove != null) {
            post.getComments().remove(commentToRemove);
            System.out.println("Comment " + commentId + " removed");
        }
    }

    public Map<String, Post> getAllPosts() {
        return new HashMap<>(posts);
    }

    public void printPostFeed(Post post) {
        System.out.println("\n" + post);
        System.out.println("Content: " + post.getContent());
        System.out.println("Likes: " + post.getLikeCount());
        System.out.println("Comments: " + post.getCommentCount());
    }
}

