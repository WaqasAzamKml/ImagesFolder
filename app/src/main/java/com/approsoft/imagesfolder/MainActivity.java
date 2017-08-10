package com.approsoft.imagesfolder;

import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.service.wallpaper.WallpaperService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<SingleImage> imagesList = new ArrayList<>();
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.smoothScrollToPosition(0);
        adapter = new RecyclerAdapter(MainActivity.this, imagesList);
        recyclerView.setAdapter(adapter);

        String[] picturesArray;
        File pictures = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Screenshots");
        if(pictures.isDirectory()){
            picturesArray = pictures.list();
            for (String picture : picturesArray) {
                String imagePath = pictures.toString() + "/" + picture;
                SingleImage image = new SingleImage(imagePath);
                imagesList.add(image);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
