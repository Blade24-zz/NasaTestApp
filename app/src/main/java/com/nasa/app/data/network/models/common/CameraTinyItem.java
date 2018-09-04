package com.nasa.app.data.network.models.common;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class CameraTinyItem {
    @JsonField(name = "name")
    private long name;
    @JsonField(name = "full_name")
    private long full_name;

    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }

    public long getFull_name() {
        return full_name;
    }

    public void setFull_name(long full_name) {
        this.full_name = full_name;
    }
}
