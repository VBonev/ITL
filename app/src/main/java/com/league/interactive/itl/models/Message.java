package com.league.interactive.itl.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 6/26/2017.
 */

public class Message {
    @SerializedName("id")
    public final String id;

    @SerializedName("senderName")
    public final String senderName;

    @SerializedName("senderAvatar")
    public final String senderAvatar;

    @SerializedName("timeSend")
    public final String timeSend;
}
