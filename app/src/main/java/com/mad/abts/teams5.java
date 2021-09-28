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

public class teams5 extends AppCompatActivity {
    public final static int PICK_IMAGE_REQUEST = 999;
    private Uri imageFile1, imageFiles2, imageFiles3, imageFiles4, imageFiles5;
    Bitmap imgs1, imgs2, imgs3, imgs4, imgs5;
    EditText venname1, venname2, venname3, venname4, venname5;
    String mvenname1, mvenname2, mvenname3, mvenname4, mvenname5;
    ImageView venpic1, venpic2, venpic3, venpic4, venpic5;
    private Context context;
    private String[] cameraPermission;
    private String[] storagePermission;

    @SuppressLint("WrongViewCast")
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams5);
        context=this;
        venpic1 = findViewById(R.id.venpic1);
        venname1 = findViewById(R.id.venname1);
        venpic2 = findViewById(R.id.venpic2);
        venname2 = findViewById(R.id.venname2);
        venpic3 = findViewById(R.id.venpic3);
        venname3 = findViewById(R.id.venname3);
        venpic4 = findViewById(R.id.venpic4);
        venname4 = findViewById(R.id.venname4);
        venpic5 = findViewById(R.id.venpic5);
        venname5 = findViewById(R.id.venname5);
        cameraPermission =new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};


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
                venpic1.setImageURI(resultUri);
                venpic2.setImageURI(resultUri);
                venpic3.setImageURI(resultUri);
                venpic4.setImageURI(resultUri);
                venpic5.setImageURI(resultUri);
            }else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void saveVenues(View view) {
        byte[] imges1 = imageViewToByte(venpic1);
        mvenname1 = venname1.getText().toString();
        byte[] imges2 = imageViewToByte(venpic2);
        mvenname2 = venname2.getText().toString();
        byte[] imges3 = imageViewToByte(venpic3);
        mvenname3 = venname3.getText().toString();
        byte[] imges4 = imageViewToByte(venpic4);
        mvenname4 = venname4.getText().toString();
        byte[] imges5 = imageViewToByte(venpic5);
        mvenname5 = venname5.getText().toString();

        DBHelperSenara dbHelper = new DBHelperSenara(this);
        if (mvenname1.isEmpty() || mvenname2.isEmpty() || mvenname3.isEmpty() || mvenname4.isEmpty() || mvenname5.isEmpty()) {
            Toast.makeText(this, "Enter Venues", Toast.LENGTH_SHORT).show();
        } else {
            Long inserted = dbHelper.addVenues(imges1, mvenname1, imges2, mvenname2, imges3, mvenname3, imges4, mvenname4, imges5, mvenname5);
        }
    }

    public void teams5(View view) {
        Intent intent = new Intent(this, teams5.class);
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
    public void teams6(View view) {
        Intent intent = new Intent(this, teams6.class);
        startActivity(intent);
    }

}
