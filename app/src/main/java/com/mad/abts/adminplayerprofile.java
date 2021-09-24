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
import android.widget.TextView;
import android.widget.Toast;

import com.mad.abts.database.DBHelperAnu;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.mad.abts.database.DBHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class adminplayerprofile extends AppCompatActivity {
    public final static int PICK_IMAGE_REQUEST=999;
    private Uri imageFilePath1;
    EditText playername, dob, teamname, country, role, battingstyle, bowlingstyle, matches, runs, fiftieshundreds, boundaries, wickets, wickethauls, overs, economy;
    String pname, tname, country1, role1, bat1, bowl1, dob1;
    int matches1, runs1, fifty1, bound1, wicket1, haul1;
    double econ, overs1;
    ImageView photo;
    Bitmap photo1;
    private Context context;
    private String[] cameraPermisiion;
    private String[] storagePermssion;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminplayerprofile);
        context=this;
        cameraPermisiion =new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermssion = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        adminplayerprofile.this,
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
                photo.setImageURI(resultUri);
            }else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void savePlayer(View view){
        pname = playername.getText().toString();
        tname = teamname.getText().toString();
        country1 = country.getText().toString();
        role1 = role.getText().toString();
        bat1 = battingstyle.getText().toString();
        bowl1 = bowlingstyle.getText().toString();
        dob1 = dob.getText().toString();
        runs1 = 0;
        matches1 = 0;
        fifty1 = 0;
        bound1 = 0;
        overs1 = 0;
        wicket1 = 0;
        haul1 = 0;
        econ = 0;
        byte[] image1 = imageViewToByte(photo);
        DBHelperAnu dbHelper =  new DBHelperAnu(this);
        if(pname.isEmpty()||tname.isEmpty() || country1.isEmpty() || role1.isEmpty() || bat1.isEmpty() || bowl1.isEmpty() || dob1.isEmpty()){
            Toast.makeText(this,"Enter Player", Toast.LENGTH_SHORT).show();
        }else{
            Long inserted = dbHelper.addPlayer(image1, pname,tname, dob1, country1, role1, bat1, bowl1, matches1, runs1, fifty1, bound1,
                    overs1, wicket1, econ, haul1);
        }
    }

    public void adminplayerprofile(View view) {
        Intent intent = new Intent(this, adminplayerprofile.class);
        startActivity(intent);
    }

    public void adminPlayerspage(View view) {
        Intent intent = new Intent(this, adminPlayerspage.class);
        startActivity(intent);
    }

    public void adminmatches(View view) {
        Intent intent = new Intent(this, adminmatches.class);
        startActivity(intent);
    }
    public void adminlive(View view) {
        Intent intent = new Intent(this, adminlive.class);
        startActivity(intent);
    }
    public void admin(View view) {
        Intent intent = new Intent(this, adminhome.class);
        startActivity(intent);
    }
    public void adminsidebar(View view) {
        Intent intent = new Intent(this, adminsidebar.class);
        startActivity(intent);
    }
    public void adminOrders(View view) {
        Intent intent = new Intent(this, adminOrders.class);
        startActivity(intent);
    }
}