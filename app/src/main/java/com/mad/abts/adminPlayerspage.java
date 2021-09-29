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

import com.mad.abts.database.DBHelperAnu;
import com.mad.abts.database.DBHelperSenara;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.mad.abts.database.DBHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

 */

public class adminPlayerspage extends AppCompatActivity {
    public final static int PICK_IMAGE_REQUEST=999;
    private Uri imafeFilePath1;
    Bitmap imge1;
    EditText playernumber, playersname, teamsname;
    String anplayernumber, anplayersname, anteamsname;
    ImageView playerimage;
    private Context context;
    private String[] cameraPermission;
    private String[] storagePermission;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_playerspage);
        context=this;
        playerimage = findViewById(R.id.imageView3);
        playernumber = findViewById(R.id.enterplayerid);
        playersname = findViewById(R.id.entername);
        teamsname = findViewById(R.id.playerteam);
        cameraPermission =new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        playerimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        adminPlayerspage.this,
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
                playerimage.setImageURI(resultUri);

            }else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void savePlayers(View view){
        byte[] image = imageViewToByte(playerimage);
        anplayernumber = playernumber.getText().toString();
        anplayersname = playersname.getText().toString();
        anteamsname = teamsname.getText().toString();

        DBHelperAnu dbHelper = new DBHelperAnu(this);
        if(anplayernumber.isEmpty()){
            Toast.makeText(this, "Enter Player No.", Toast.LENGTH_SHORT).show();
        }else{
            dbHelper.addPlayers(image, anplayernumber, anplayersname, anteamsname);
        }
    }

    public void updatePlayers(View view){
        byte[] image = imageViewToByte(playerimage);
        anplayernumber = playernumber.getText().toString();
        anplayersname = playersname.getText().toString();
        anteamsname = teamsname.getText().toString();

        DBHelperAnu dbHelper = new DBHelperAnu(this);
        if(anplayernumber.isEmpty()){
            Toast.makeText(this, "Enter Player No.", Toast.LENGTH_SHORT).show();
        }else{
            dbHelper.updatePlayers(image, anplayernumber, anplayersname, anteamsname);
        }
    }

    public void deletePlayers(View view){
        anplayernumber = playernumber.getText().toString();

        DBHelperAnu dbHelper =  new DBHelperAnu(this);
        dbHelper.deletePlayers(anplayernumber);
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