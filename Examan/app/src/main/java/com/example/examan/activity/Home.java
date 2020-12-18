package com.example.examan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examan.constant.*;

import android.os.Bundle;
import android.os.RecoverySystem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.examan.R;
import com.example.examan.adapter.HomeItems;
import com.example.examan.model.ItemHome;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private HomeItems adapter;
    private ArrayList<ItemHome> itemHome =new ArrayList<ItemHome>() ;
    private GridView gridView;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listview = (ListView) findViewById(R.id.listview);
        adapter = new HomeItems(itemHome, this);

        getJsonItems();

        adapter = new HomeItems(itemHome, this);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    public void getJsonItems(){
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(readJSONFromAsset());
            JSONArray jsonArray = null;
            jsonArray = jsonObj.getJSONArray("items");

            for(int i=0; i< jsonArray.length();i++){
                JSONObject itemObj = null;
                itemObj = jsonArray.getJSONObject(i);

                ItemHome item = new ItemHome(itemObj.getInt("id") ,
                        itemObj.getString("title"),
                        itemObj.getString("details")
                );
                itemHome.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("items.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}