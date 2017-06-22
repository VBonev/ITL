package com.league.interactive.itl.models;

import com.google.gson.annotations.SerializedName;

public class Tournament {
    public static final String TOURNAMENT_NAME = "tournament_name";
    @SerializedName("id")
    public final String id;
    @SerializedName("name")
    public final String name;
    @SerializedName("location")
    public final String location;
    @SerializedName("date")
    public final String date;
    @SerializedName("registered")
    public final boolean registered;

    Tournament(String id, String name, String location, String date, boolean registered) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
        this.registered = registered;
    }

}
