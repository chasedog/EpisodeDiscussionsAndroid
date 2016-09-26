package com.thechasedog.episodediscussions.models;

import java.util.ArrayList;
import java.util.List;
/*

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.RealmList;
*/

public class Subreddit {//} extends RealmObject {
//    @PrimaryKey
    public int Id;
    public String Name;
    public List<Season> seasons;

    public Subreddit() {
        seasons = new ArrayList<>();
    }

    public Subreddit(String name) {
        setName(name);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
}
