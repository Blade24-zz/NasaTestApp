package com.nasa.app.data.network.models.common;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.ArrayList;

@JsonObject
public class RoverItem {
    @JsonField(name = "id")
    private int id;
    @JsonField(name = "name")
    private String name;
    @JsonField(name = "landing_date")
    private String landingDate;
    @JsonField(name = "launch_date")
    private String launchDate;
    @JsonField(name = "status")
    private String status;
    @JsonField(name = "max_sol")
    private long maxSol;
    @JsonField(name = "max_date")
    private String maxDate;
    @JsonField(name = "total_photos")
    private long totalPhotos;
    @JsonField(name = "cameras")
    private ArrayList<CameraTinyItem> cameras;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLandingDate() {
        return landingDate;
    }

    public void setLandingDate(String landingDate) {
        this.landingDate = landingDate;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getMaxSol() {
        return maxSol;
    }

    public void setMaxSol(long maxSol) {
        this.maxSol = maxSol;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    public long getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(long totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    public ArrayList<CameraTinyItem> getCameras() {
        return cameras;
    }

    public void setCameras(ArrayList<CameraTinyItem> cameras) {
        this.cameras = cameras;
    }
}
