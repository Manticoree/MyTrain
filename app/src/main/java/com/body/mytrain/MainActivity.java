package com.body.mytrain;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.body.mytrain.entities.AnotherTrainElement;
import com.body.mytrain.entities.TrainElement;
import com.body.mytrain.entities.bd.AppDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int OPEN_FILE = 300;

    public final int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 1;

//requests for runtime time permissions


    String WRITE_EXTERNAL_STORAGE_PERMISSION = android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

    @BindView(R.id.rvSportLists)
    RecyclerView rvListTrain;
    @BindView(R.id.rvAnotherTrain)
    RecyclerView rvAnotherTrain;
    @BindView(R.id.fabPersonPhoto)
    FloatingActionButton fabPersonPhoto;

    private AppDatabase persondb;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_sport_layout);
        ButterKnife.bind(this);
        mContext = getApplicationContext();
        persondb = Room.databaseBuilder(mContext, AppDatabase.class, "person-database")
                .build();
        getFlexibleAdapter(rvListTrain, getDatabaseList(), LinearLayoutManager.VERTICAL);
        getFlexibleAdapter(rvAnotherTrain, getAnotherList(), LinearLayoutManager.HORIZONTAL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                getPhotoFromCamera(imageBitmap);
            } else {
                if (requestCode == OPEN_FILE) {
                    Uri choseFileUrl = data.getData();
                    if (choseFileUrl != null) {
                        getPhotoFromGallery(choseFileUrl);
                    }
                }
            }
        }
    }


    private void getFlexibleAdapter(RecyclerView recyclerView,
                                    List<IFlexible> databaseList,
                                    int orientation) {
        FlexibleAdapter<IFlexible> adapter;
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,
                orientation, false);
        recyclerView.setLayoutManager(manager);
        List<IFlexible> items = databaseList;
        adapter = new FlexibleAdapter<>(items);
        adapter.addListener(this);
        recyclerView.setAdapter(adapter);
    }


    public List<IFlexible> getDatabaseList() {
        List<IFlexible> list = new ArrayList<>();
        list.add(new TrainElement("1", R.string.train_in_gym, R.drawable.woman_in_gym, mContext));
        list.add(new TrainElement("2", R.string.train_in_street, R.drawable.train_in_street, mContext));
        list.add(new TrainElement("3", R.string.train_on_workout, R.drawable.train_on_workout, mContext));
        list.add(new TrainElement("4", R.string.home_train, R.drawable.home_train, mContext));
        list.add(new TrainElement("5", R.string.train_jog, R.drawable.train_jog, mContext));
        return list;
    }

    public List<IFlexible> getAnotherList() {
        List<IFlexible> list = new ArrayList<>();
        list.add(new AnotherTrainElement("1", R.string.run_train, R.drawable.another_train_run, mContext));
        list.add(new AnotherTrainElement("2", R.string.run_train, R.drawable.another_train_run, mContext));
        list.add(new AnotherTrainElement("3", R.string.run_train, R.drawable.another_train_run, mContext));
        return list;

    }


    @OnClick(R.id.fabPersonPhoto)
    void addPhoto(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.select_image);
        builder.setCancelable(true);
        builder.setNeutralButton(R.string.camera, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                takePictureFromCamera();
            }
        });
        builder.setPositiveButton(R.string.gallery, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                takePictureFromGallery();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void takePictureFromCamera() {
        Intent takePicturefromCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePicturefromCamera.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePicturefromCamera, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void takePictureFromGallery() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, REQUEST_IMAGE_CAPTURE);
    }

    public void getPhotoFromCamera(Bitmap pathToImage) {
        /*
        Picasso.get()
                .load(pathToImage.)
                .into(fabPersonPhoto);

         */

        fabPersonPhoto.setImageBitmap(pathToImage);
    }

    public void getPhotoFromGallery(Uri uri) {
        Picasso.get()
                .load(uri.getPath())
                .into(fabPersonPhoto);
    }


}
