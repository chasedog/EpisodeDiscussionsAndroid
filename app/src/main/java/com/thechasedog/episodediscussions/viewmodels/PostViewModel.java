package com.thechasedog.episodediscussions.viewmodels;

import com.thechasedog.episodediscussions.models.Post;

public class PostViewModel {
    public Post Post;

    public PostViewModel(Post post) {
        Post = post;
    }

    public String getUps() {
        return Integer.toString(Post.getUps());
    }

    public String getTitle() {
        return Post.getTitle();
    }
}
