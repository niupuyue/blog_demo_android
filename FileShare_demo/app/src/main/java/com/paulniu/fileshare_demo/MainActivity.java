package com.paulniu.fileshare_demo;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ImageView)findViewById(R.id.img)).setImageBitmap(BitmapFactory.decodeFile("storage/emulated/0/DCIM/Screenshots/Screenshot_2018-06-11-16-07-13-935_cn.com.cs2c.cs2c_office.png®"));

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if(Intent.ACTION_SEND.equals(action) && type != null && "image/png".equals(type)){
            Uri uri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
            String filePath = null;
            if ("content".equalsIgnoreCase(uri.getScheme())){
                // 如果是 content 类型的 Uri
                filePath = getDataColumn(MainActivity.this, uri, null, null);
            } else if ("file".equals(uri.getScheme())) {
                // 如果是 file 类型的 Uri,直接获取图片对应的路径
                filePath = uri.getPath();
            }
            ImageView im = findViewById(R.id.img);
            im.setImageBitmap(BitmapFactory.decodeFile(filePath));
            Log.i("img",filePath);
        }
    }

    private static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        String path = null;

        String[] projection = new String[]{MediaStore.Images.Media.DATA};
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndexOrThrow(projection[0]);
                path = cursor.getString(columnIndex);
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return path;
    }

}
