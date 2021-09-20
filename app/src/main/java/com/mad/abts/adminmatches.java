package com.mad.abts;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
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
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.mad.abts.database.DBHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class adminmatches extends AppCompatActivity {
    public final static int PICK_IMAGE_REQUEST=999;
    private Uri imageFilePath1,imageFilePath2;
    Bitmap img1,img2;
    EditText team1,team2,matchno,matchdate;
    String team11,team22,date;
    int matchno1,runs1,runs2,wickets1,wickets2;
    double overs1,overs2;
    ImageView logo1,logo2;
    private Context context;
    private String[] cameraPermisiion;
    private String[] storagePermssion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmatches);
        context=this;
        team1 = findViewById(R.id.inteam1);
        team2= findViewById(R.id.inteam2);
        matchno= findViewById(R.id.matchnoin1);
        matchdate= findViewById(R.id.inmatchdate);
        logo1= findViewById(R.id.logo1);
        logo2= findViewById(R.id.logo2);
        cameraPermisiion =new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermssion = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        logo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        adminmatches.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PICK_IMAGE_REQUEST
                );
            }
        });
        logo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        adminmatches.this,
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
                logo1.setImageURI(resultUri);
                logo2.setImageURI(resultUri);
            }else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
    public void saveMatch(View view){
        team11 = team1.getText().toString();
        team22 = team2.getText().toString();
        matchno1 = Integer.parseInt(matchno.getText().toString());
        date = matchdate.getText().toString();
        runs1 = 0;
        runs2 = 0;
        wickets1 = 0;
        wickets2 = 0;
        overs1 = 0;
        overs2 = 0;
        byte[] image1 = imageViewToByte(logo1);
        byte[] image2 = imageViewToByte(logo2);
        DBHelper dbHelper =  new DBHelper(this);
        if(team11.isEmpty()||team22.isEmpty()){
            Toast.makeText(this,"Enter Teams", Toast.LENGTH_SHORT).show();
        }else{
            dbHelper.addMatch(team11,team22,matchno1,date,runs1,runs2,wickets1,wickets2,overs1,overs2,image1,image2);
        }
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
}