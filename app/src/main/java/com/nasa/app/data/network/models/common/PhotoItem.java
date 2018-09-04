package com.nasa.app.data.network.models.common;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class PhotoItem {
    @JsonField(name = "id")
    private long id;
    @JsonField(name = "sol")
    private long sol;
    @JsonField(name = "camera")
    private CameraFullItem camera;
    @JsonField(name = "img_src")
    private String imgSrc;
    @JsonField(name = "earth_date")
    private String earthDate;
    @JsonField(name = "rover")
    private RoverItem rover;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSol() {
        return sol;
    }

    public void setSol(long sol) {
        this.sol = sol;
    }

    public CameraFullItem getCamera() {
        return camera;
    }

    public void setCamera(CameraFullItem camera) {
        this.camera = camera;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getEarthDate() {
        return earthDate;
    }

    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    public RoverItem getRover() {
        return rover;
    }

    public void setRover(RoverItem rover) {
        this.rover = rover;
    }
}
