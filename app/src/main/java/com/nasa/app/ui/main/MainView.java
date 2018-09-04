package com.nasa.app.ui.main;

import com.nasa.app.data.network.models.common.PhotoItem;
import com.nasa.app.mvp.MvpView;

import java.util.ArrayList;

public interface MainView extends MvpView<MainPresenter> {
    void loadRoverPhotosSuccess(ArrayList<PhotoItem> photoItems);
    void loadRoverPhotosFailed();
}
