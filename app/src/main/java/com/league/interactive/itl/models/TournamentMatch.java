package com.league.interactive.itl.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TournamentMatch {
    public static final String FINISHED_STATUS = "finished";
    public static final String IN_PROGRESS_STATUS = "in progress";
    public static final String UPCOMING_STATUS = "upcoming";

    @SerializedName("id")
    public final String id;
    @SerializedName("playerOne")
    public final String playerOne;
    @SerializedName("playerTwo")
    public final String playerTwo;
    @SerializedName("avatarOne")
    public final String avatarOne;
    @SerializedName("avatarTwo")
    public final String avatarTwo;
    @SerializedName("matchStatus")
    public final String matchStatus;
    @SerializedName("result")
    public final String result;

    public TournamentMatch(String id,
                           String playerOne,
                           String playerTwo,
                           String avatarOne,
                           String avatarTwo,
                           String matchStatus,
                           String result) {
        this.id = id;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.avatarOne = avatarOne;
        this.avatarTwo = avatarTwo;
        this.matchStatus = matchStatus;
        this.result = result;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public String getAvatarOne() {
        return avatarOne;
    }

    public String getAvatarTwo() {
        return avatarTwo;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public String getResults() {
        return result;
    }
}
