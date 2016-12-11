package com.league.interactive.itl.models;

/**
 * Created by Valio on 12/2/2016.
 */

public class Tournament {
    public final String id;
    public final String name;
    public final String location;
    public final String date;
    public final boolean registered;

    public Tournament(String id, String name, String location, String date, boolean registered) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
        this.registered = registered;
    }

}
