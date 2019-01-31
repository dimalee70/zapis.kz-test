package com.example.dmitriyl.helloworld.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SaloonsResponce
{
    @SerializedName("salons")
    private List<Saloon> responce;

    public List<Saloon> getResponce() {
        return responce;
    }

    public void setResponce(List<Saloon> responce) {
        this.responce = responce;
    }
}
