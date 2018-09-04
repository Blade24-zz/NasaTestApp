package com.nasa.app.data.network.models.response;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.nasa.app.data.network.models.common.PhotoItem;

import java.util.ArrayList;

@JsonObject
public class MarsPhotoResponse {
    @JsonField(name = "photos")
    private ArrayList<PhotoItem> photos;

    public ArrayList<PhotoItem> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<PhotoItem> photos) {
        this.photos = photos;
    }
}
