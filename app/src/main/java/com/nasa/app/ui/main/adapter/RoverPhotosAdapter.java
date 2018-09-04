package com.nasa.app.ui.main.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nasa.R;
import com.nasa.app.data.network.models.common.PhotoItem;

import java.util.List;

public class RoverPhotosAdapter extends BaseQuickAdapter<PhotoItem, BaseViewHolder> {

    public RoverPhotosAdapter(int layoutResId, @Nullable List<PhotoItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PhotoItem item) {
        helper.setText(R.id.tv_cameraName, item.getCamera().getFullName());
        helper.setText(R.id.tv_roverName, item.getRover().getName());
        Glide.with(mContext).load(item.getImgSrc())
                .into((ImageView) helper.getView(R.id.iv_roverImage));
    }
}
