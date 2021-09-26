package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.mad.abts.database.DBHelperSenara;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class teams4  extends AppCompatActivity{
    public final static int PICK_IMAGE_REQUEST = 999;
    private Uri imageFile1;
    Bitmap img1;
    EditText team, captain;
    String mteam, mcaptain;
    ImageView logo;
    private Context context;
    private String[] cameraPermission;
    private String[] storagePermission;

    //@SuppressLint("WrongViewCast")
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams4);
        context=this;
        logo = findViewById(R.id.logoimage1);
        team = findViewById(R.id.tname);
        captain = findViewById(R.id.newcapname);
        //logo = findViewById(R.id,logoimage2);

        cameraPermission =new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        teams4.this,
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
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,PICK_IMAGE_REQUEST);
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
                logo.setImageURI(resultUri);

            }else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void saveTeams(View view){
        byte[] images1 = imageViewToByte(logo);
        mteam = team.getText().toString();
        mcaptain = captain.getText().toString();


        DBHelperSenara dbHelper = new DBHelperSenara(this);
        if(mteam.isEmpty()){
            Toast.makeText(this, "Enter Teams", Toast.LENGTH_SHORT).show();
        }else{
            Long inserted = dbHelper.addTeams(images1,mteam,mcaptain);
        }
    }
    public void updateTeams(View view) {
        mteam = team.getText().toString();
        mcaptain = captain.getText().toString();
        DBHelperSenara dbHelper = new DBHelperSenara(this);
        if (mteam.isEmpty()) {
            System.out.println("team");
            Toast.makeText(this, "Enter Team", Toast.LENGTH_SHORT).show();
        } else {
            dbHelper.updateTeams(mteam, mcaptain);
        }
    }

    public void deleteTeams(View view){
        mteam = team.getText().toString();

        DBHelperSenara dbHelper = new DBHelperSenara(this);
        dbHelper.deleteTeams(mteam, mcaptain);
    }

    public void teams6(View view) {
        Intent intent = new Intent(this, teams6.class);
        startActivity(intent);
    }

    public void teams4(View view) {
        Intent intent = new Intent(this, teams4.class);
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
