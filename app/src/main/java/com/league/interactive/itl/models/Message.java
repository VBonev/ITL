package com.league.interactive.itl.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 6/26/2017.
 */

public class Message {
    @SerializedName("id")
    private final String id;

    @SerializedName("senderName")
    private final String senderName;
    @SerializedName("messageValue")
    private final String messageValue;
    @SerializedName("senderAvatar")
    private final String senderAvatar;

    @SerializedName("messageTime")
    private final String messageTime;

    public Message(String id, String senderName, String messageValue, String senderAvatar, String messageTime) {
        this.id = id;
        this.senderName = senderName;
        this.messageValue = messageValue;
        this.senderAvatar = senderAvatar;
        this.messageTime = messageTime;
    }

    public String getId() {
        return id;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderAvatar() {
        return senderAvatar;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public String getMessageValue() {
        return messageValue;
    }
}
