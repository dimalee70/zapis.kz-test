package com.example.dmitriyl.helloworld.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SaloonInfo
{
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private  String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("workStartTime")
    @Expose
    private String workStartTime;
    @SerializedName("workEndTime")
    @Expose
    private String workEndTime;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("checkRating")
    @Expose
    private  String checkRating;
    @SerializedName("instagramProfile")
    @Expose
    private String instagramProfile;
    @SerializedName("avatarUrl")
    @Expose
    private String avatarUrl;
    @SerializedName("reviewCount")
    @Expose
    private String reviewCount;
    @SerializedName("averageRating")
    @Expose
    private String averageRating;
    @SerializedName("phoneNumbers")
    @Expose
    private List<String> phoneNumbers;
    @SerializedName("todayReservationsCount")
    @Expose
    private String todayReservationsCount;
    @SerializedName("pictures")
    @Expose
    String[] pictures;

    public SaloonInfo(String id, String name, String address, String workStartTime, String workEndTime, String description, String type, String checkRating, String instagramProfile, String avatarUrl, String reviewCount, String averageRating, List<String> phoneNumbers, String todayReservationsCount, String[] pictures) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.description = description;
        this.type = type;
        this.checkRating = checkRating;
        this.instagramProfile = instagramProfile;
        this.avatarUrl = avatarUrl;
        this.reviewCount = reviewCount;
        this.averageRating = averageRating;
        this.phoneNumbers = phoneNumbers;
        this.todayReservationsCount = todayReservationsCount;
        this.pictures = pictures;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(String workStartTime) {
        this.workStartTime = workStartTime;
    }

    public String getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getInstagramProfile() {
        return instagramProfile;
    }

    public void setInstagramProfile(String instagramProfile) {
        this.instagramProfile = instagramProfile;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(String reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }


    public String getTodayReservationsCount() {
        return todayReservationsCount;
    }

    public void setTodayReservationsCount(String todayReservationsCount) {
        this.todayReservationsCount = todayReservationsCount;
    }

    public String[] getPictures() {
        return pictures;
    }

    public void setPictures(String[] pictures) {
        this.pictures = pictures;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "SaloonInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", workStartTime='" + workStartTime + '\'' +
                ", workEndTime='" + workEndTime + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", checkRating='" + checkRating + '\'' +
                ", instagramProfile='" + instagramProfile + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", reviewCount='" + reviewCount + '\'' +
                ", averageRating='" + averageRating + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", todayReservationsCount='" + todayReservationsCount + '\'' +
                ", pictures=" + pictures +
                '}';
    }
}
