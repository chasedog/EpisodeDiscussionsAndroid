package com.thechasedog.episodediscussions.models;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Subreddit extends RealmObject {
    @PrimaryKey
    public int Id;
    public String Name;
    public RealmList<Post> Posts;

    public Subreddit(String name) {
        setName(name);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Post> getPosts() {
        return Posts;
    }

    public void setPosts(RealmList<Post> posts) {
        Posts = posts;
    }
}
