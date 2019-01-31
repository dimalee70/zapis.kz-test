package com.example.dmitriyl.helloworld.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Saloon
{
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private  String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("checkRating")
    @Expose
    private  String checkRating;
    @SerializedName("pictureUrl")
    @Expose
    private String pictureUrl;

    public Saloon(String id, String name, String type, String checkRating, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.checkRating = checkRating;
        this.pictureUrl = pictureUrl;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCheckRating() {
        return checkRating;
    }

    public void setCheckRating(String checkRating) {
        this.checkRating = checkRating;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    @Override
    public String toString() {
        return "Saloon{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", checkRating='" + checkRating + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
