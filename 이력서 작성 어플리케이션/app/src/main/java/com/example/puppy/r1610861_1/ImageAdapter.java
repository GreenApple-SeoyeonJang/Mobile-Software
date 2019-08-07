package com.example.puppy.r1610861_1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public Integer[] mImageIds = {
            R.drawable.artscrafts,
            R.drawable.chemicalbiological,
            R.drawable.chemistry,
            R.drawable.chinese,
            R.drawable.computerscience
    };

    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mImageIds[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new Gallery.LayoutParams(300, 400));
        }else{
            imageView = (ImageView)convertView;
        }
        imageView.setImageResource(mImageIds[position]);

        return imageView;
    }

}
