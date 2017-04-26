package com.league.interactive.itl.models;

import com.google.gson.annotations.SerializedName;

public class RankPlayer {

    @SerializedName("id")
    public final String id;
    @SerializedName("position")
    public final int position;
    @SerializedName("name")
    public final String name;
    @SerializedName("town")
    public final String town;
    @SerializedName("rank")
    public final int rank;
    @SerializedName("points")
    public final int points;

    RankPlayer(String id, int position, String name, String town, int rank, int points) {
        this.id = id;
        this.position = position;
        this.name = name;
        this.town = town;
        this.rank = rank;
        this.points = points;
    }

    @Override
    public String toString() {
        return name;
    }
}