package com.example.dmitriyl.helloworld.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaloonInfoResponce
{
    @SerializedName("salon")
    @Expose
    private SaloonInfo saloonInfo;
    @Override
    public String toString() {
        return "SaloonInfoResponce{" +
                "saloonInfo=" + saloonInfo +
                '}';
    }

    public SaloonInfo getSaloonInfo() {
        return saloonInfo;
    }

    public void setSaloonInfo(SaloonInfo saloonInfo) {
        this.saloonInfo = saloonInfo;
    }

    public SaloonInfoResponce(SaloonInfo saloonInfo) {
        this.saloonInfo = saloonInfo;
    }


}
