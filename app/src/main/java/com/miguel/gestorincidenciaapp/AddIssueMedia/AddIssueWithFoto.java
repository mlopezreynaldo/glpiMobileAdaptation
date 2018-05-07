package com.miguel.gestorincidenciaapp.AddIssueMedia;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.miguel.gestorincidenciaapp.R;

public class AddIssueWithFoto extends AppCompatActivity {


    private String mCurrentPhotoPath;
    static final int REQUEST_TAKE_PHOTO = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_issue_with_foto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    createCameraFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                openCamera();
            }
        });
    }

    private File createCameraFile() throws IOException {

        String timeStamp = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date());
        String imageExtension = "JPEG_" + timeStamp + "_";
        File storeDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        File image = File.createTempFile(
                imageExtension,
                ".jpg",
                storeDir
        );

        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }

    private void openCamera() {

        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePicture.resolveActivity(getPackageManager()) != null) {

            File photoFile = null;

            try {

                photoFile = createCameraFile();

            } catch (IOException e) {

                e.printStackTrace();
            }

            if(photoFile != null){

                takePicture.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));

                startActivityForResult(takePicture, REQUEST_TAKE_PHOTO);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





}
