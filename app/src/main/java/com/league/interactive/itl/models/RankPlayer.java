package com.league.interactive.itl.models;

public class RankPlayer {
    public final String id;
    public final int position;
    public final String name;
    public final String town;
    public final int rank;
    public final int points;

    public RankPlayer(String id, int position, String name, String town, int rank, int points) {
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