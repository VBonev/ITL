package com.league.interactive.itl.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Valio on 4/29/2017.
 */

public class DummyModel {

    @SerializedName("nid")
    public final String nid;
    @SerializedName("vid")
    public final String vid;
    @SerializedName("type")
    public final String type;
    @SerializedName("language")
    public final String language;
    @SerializedName("title")
    public final String title;
    @SerializedName("uid")
    public final String uid;
    @SerializedName("status")
    public final String status;
    @SerializedName("created")
    public final String created;
    @SerializedName("changed")
    public final String changed;
    @SerializedName("comment")
    public final String comment;
    @SerializedName("promote")
    public final String promote;
    @SerializedName("sticky")
    public final String sticky;
    @SerializedName("tnid")
    public final String tnid;
    @SerializedName("translate")
    public final String translate;
    @SerializedName("uri")
    public final String uri;

    public DummyModel(String nid, String vid, String type, String language, String title, String uid, String status, String created, String changed, String comment, String promote, String sticky, String tnid, String translate, String uri) {
        this.nid = nid;
        this.vid = vid;
        this.type = type;
        this.language = language;
        this.title = title;
        this.uid = uid;
        this.status = status;
        this.created = created;
        this.changed = changed;
        this.comment = comment;
        this.promote = promote;
        this.sticky = sticky;
        this.tnid = tnid;
        this.translate = translate;
        this.uri = uri;
    }
}
