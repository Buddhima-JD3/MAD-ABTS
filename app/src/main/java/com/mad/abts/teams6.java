package com.mad.abts;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mad.abts.database.DBHelperSenara;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.mad.abts.database.DBHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class teams6 extends AppCompatActivity{
    public final static int PICK_IMAGE_REQUEST=999;
    private Uri imageFilePath1;
    Bitmap img1;
    EditText teamname, bowlername, highesttotal, lowesttotal, mostruns, mostwickets;
    String mteamname, mbowlername;
    int mhighesttotal, mlowesttotal, mmostruns, mmostwickets;
    ImageView teamlogo;
    private Context context;
    private String[] cameraPermission;
    private String[] storagePermission;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmatches);
        context=this;
        teamlogo = findViewById(R.id.logoinsertname2);
        teamname= findViewById(R.id.inteam2);
        highesttotal = findViewById(R.id.insert1);
        lowesttotal = findViewById(R.id.insert2);
        mostruns = findViewById(R.id.insert3);
        mostwickets = findViewById(R.id.insert4);
        bowlername = findViewById(R.id.insert5);
        cameraPermission =new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        teamlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        teams6.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PICK_IMAGE_REQUEST
                );
            }
        });

    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==PICK_IMAGE_REQUEST){
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                //gallery intent
                Intent gallertIntent = new Intent(Intent.ACTION_GET_CONTENT);
                gallertIntent.setType("image/*");
                startActivityForResult(gallertIntent,PICK_IMAGE_REQUEST);
            }else{
            }
            return;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==PICK_IMAGE_REQUEST && resultCode ==RESULT_OK){
            Uri imageUri = data.getData();
            CropImage.activity(imageUri)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1,1)
                    .start(this);
        }
        if(requestCode== CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if(resultCode ==RESULT_OK){
                Uri resultUri = result.getUri();
                //set image choose from gallery to image view
                teamlogo.setImageURI(resultUri);

            }else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void saveTeamStat(View view){
        byte[] image = imageViewToByte(teamlogo);
        mteamname = teamname.getText().toString();
        mhighesttotal = Integer.parseInt(highesttotal.getText().toString());
        mlowesttotal = Integer.parseInt(lowesttotal.getText().toString());
        mmostruns = Integer.parseInt(mostruns.getText().toString());
        mmostwickets = Integer.parseInt(mostwickets.getText().toString());
        mbowlername = bowlername.getText().toString();

        DBHelperSenara dbHelper = new DBHelperSenara(this);
        if(mteamname.isEmpty()){
            Toast.makeText(this, "Enter Team", Toast.LENGTH_SHORT).show();
        }else{
            dbHelper.addTeamStat(image, mteamname, mhighesttotal, mlowesttotal, mmostruns, mmostwickets, mbowlername);
        }

    }

    public void admin(View view) {
        Intent intent = new Intent(this, adminhome.class);
        startActivity(intent);
    }
    public void adminsidebar(View view) {
        Intent intent = new Intent(this, adminsidebar.class);
        startActivity(intent);
    }
    public void teams6(View view) {
        Intent intent = new Intent(this, teams6.class);
        startActivity(intent);
    }
}
