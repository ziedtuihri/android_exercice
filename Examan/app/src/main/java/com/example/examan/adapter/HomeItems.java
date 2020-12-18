package com.example.examan.adapter;

import com.example.examan.R;
import com.example.examan.activity.Detail;
import com.example.examan.activity.Home;
import com.example.examan.model.ItemHome;
import com.google.android.material.snackbar.Snackbar;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeItems extends ArrayAdapter<ItemHome> implements View.OnClickListener{

    private ArrayList<ItemHome> dataSet;
    Context mContext;

    public HomeItems(@NonNull Context context, int resource) {
        super(context, resource);
    }

    // View lookup cache
    private static class ViewHolder {
        TextView txtTitle;
        ImageView image;
    }

    public HomeItems(ArrayList<ItemHome> data, Context context) {
        super(context, R.layout.item_home, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {
        int position=(Integer) v.getTag();
        Object object= getItem(position);
        ItemHome dataModel = (ItemHome)object;

        switch (v.getId())
        {
            case R.id.imageView:
                Intent intent = new Intent(mContext, Detail.class);
                intent.putExtra("title", dataModel.getTitle());
                intent.putExtra("detail", dataModel.getDetails());
                mContext.startActivity(intent);
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ItemHome dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_home, parent, false);
            viewHolder.txtTitle = (TextView) convertView.findViewById(R.id.txt_title);

            viewHolder.image = (ImageView) convertView.findViewById(R.id.imageView);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        lastPosition = position;

        viewHolder.txtTitle.setText(dataModel.getTitle());

        String uri = "@drawable/" + dataModel.getTitle().toLowerCase();
        int imageResource = mContext.getResources().getIdentifier(uri, null, mContext.getPackageName());
        Drawable res = mContext.getResources().getDrawable(imageResource);
        viewHolder.image.setImageDrawable(res);

        viewHolder.image.setOnClickListener(this);
        viewHolder.image.setTag(position);

        return convertView;
    }


}
