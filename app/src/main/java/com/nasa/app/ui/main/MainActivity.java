package com.nasa.app.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nasa.R;
import com.nasa.app.data.network.models.common.PhotoItem;
import com.nasa.app.ui.base.BaseActivity;
import com.nasa.app.ui.main.adapter.RoverPhotosAdapter;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.rv_roverPhotos)
    RecyclerView rvRoverPhotos;

    private RoverPhotosAdapter mAdapter;

    @Override
    protected void onViewReady(Bundle savedInstanceState) {

        rvRoverPhotos.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RoverPhotosAdapter(R.layout.item_rover_photo, new ArrayList());
        rvRoverPhotos.setAdapter(mAdapter);

        getPresenter().loadRoverPhotosFromMars();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void loadRoverPhotosSuccess(ArrayList<PhotoItem> photoItems) {
        mAdapter.setNewData(photoItems);
    }

    @Override
    public void loadRoverPhotosFailed() {

    }
}
