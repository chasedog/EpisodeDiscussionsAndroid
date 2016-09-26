package com.thechasedog.episodediscussions.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chase Dog on 9/25/2016.
 */

public class Season {
    public int SeasonNumber;
    public boolean IsRewatch;
    public List<Episode> Episodes;

    public Season() {
        Episodes = new ArrayList<>();
    }
}
