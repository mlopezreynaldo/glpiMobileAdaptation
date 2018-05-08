package com.miguel.gestorincidenciaapp.AddIssueMedia;

import android.app.DownloadManager;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;
import static android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
import static android.provider.MediaStore.Images.Media.query;


import com.google.android.gms.vision.barcode.Barcode;
import com.miguel.gestorincidenciaapp.R;

import java.io.File;
import java.util.List;

import info.androidhive.barcode.BarcodeReader;


public class AddIssueWithFotoFragment extends Fragment{

    private DownloadManager contentResolver;
    private static final int SELECT_PICTURE = 1;

    public AddIssueWithFotoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_add_issue_with_foto, container, false);


        Button button = inflate.findViewById(R.id.openGalery);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_PICK, EXTERNAL_CONTENT_URI);
                startActivityForResult(i, SELECT_PICTURE);
            }
        });

        return inflate;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case SELECT_PICTURE:
                if (requestCode == RESULT_OK) {
                    Uri seleccion = data.getData();
                    String[] columna = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getActivity().getContentResolver().query(seleccion,
                            columna, null,
                            null, null);

                    cursor.moveToFirst();

                    int indexColumna = cursor.getColumnIndex(columna[0]);
                    String file = cursor.getString(indexColumna);
                    cursor.close();

                    File openFile = new File(file);

                    Intent i = new Intent();
                    i.setAction(Intent.ACTION_VIEW);

                    i.setDataAndType(Uri.fromFile(openFile), "");
                }
                break;
        }
    }

}
