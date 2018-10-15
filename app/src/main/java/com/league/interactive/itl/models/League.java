package com.league.interactive.itl.models;

import com.google.gson.annotations.SerializedName;

public class League {

    @SerializedName("id")
    private final String id;
    @SerializedName("isDefault")
    private final boolean isDefault;
    @SerializedName("title")
    private final String title;
    @SerializedName("subtitle")
    private final String subtitle;
    @SerializedName("town")
    private final String town;
    @SerializedName("contacts")
    private final LeagueContacts contacts;
    @SerializedName("description")
    private final String description;
    @SerializedName("icon")
    private final String icon;
    @SerializedName("coverImg")
    private final int coverImg;

    public League(String id, boolean isDefault, String title, String subtitle, String town, LeagueContacts contacts, String description, String icon, int coverImg) {
        this.id = id;
        this.isDefault = isDefault;
        this.title = title;
        this.subtitle = subtitle;
        this.town = town;
        this.contacts = contacts;
        this.description = description;
        this.icon = icon;
        this.coverImg = coverImg;
    }

    @Override
    public String toString() {
        return title;
    }

    public static class LeagueContacts {
        @SerializedName("contactName")
        private final String contactName;
        @SerializedName("mobile")
        private final String mobile;
        @SerializedName("email")
        private final String email;
        @SerializedName("website")
        private final String website;
        @SerializedName("fbPage")
        private final String fbPage;

        public LeagueContacts(String contactName, String mobile, String email, String website, String fbPage) {
            this.contactName = contactName;
            this.mobile = mobile;
            this.email = email;
            this.website = website;
            this.fbPage = fbPage;
        }
    }

    public String getId() {
        return id;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getTown() {
        return town;
    }

    public LeagueContacts getContacts() {
        return contacts;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public int getCoverImg() {
        return coverImg;
    }
}
