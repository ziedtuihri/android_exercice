package com.example.examan.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.examan.R;
import com.example.examan.model.ItemHome;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    TextView edt_title, edt_details;
    ImageView image;
    String Title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();

        Intent i = getIntent();
        Title =  i.getStringExtra("title");
        String detail =  i.getStringExtra("detail");

        edt_title.setText(Title.toString());
        edt_details.setText(detail.toString());
        getImage();
    }

    public void getImage(){
        String uri = "@drawable/" + Title.toLowerCase() + "_image";
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        image.setImageDrawable(res);
    }

    public void initViews(){
        edt_title        = findViewById(R.id.txt_title);
        edt_details      = findViewById(R.id.txt_details);
        image            = findViewById(R.id.imageItem);
    }
}