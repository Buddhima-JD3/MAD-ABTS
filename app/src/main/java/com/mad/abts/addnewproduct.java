package com.mad.abts;

import androidx.appcompat.app.AppCompatActivity;
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
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mad.abts.database.DBHelperBuddhi;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.mad.abts.database.DBHelper;

import java.io.ByteArrayOutputStream;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addnewproduct extends AppCompatActivity {
    public final static int PICK_IMAGE_REQUEST = 999;
    EditText et1, et2,et5, et3, et4;
    ImageView img;
    String e1,e2,e5;
    int e3;
    double e4, e6;
    private Context context;
    private String[] cameraPermisiion;
    private String[] storagePermssion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewproduct);
        et1 = findViewById(R.id.newproductname);
        et2 = findViewById(R.id.newproductdescription);
        et3 = findViewById(R.id.newproductquantity);
        et4 = findViewById(R.id.newproductprice);
        et5 = findViewById(R.id.categoryin);

        img = findViewById(R.id.newproductimg);
        cameraPermisiion =new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermssion = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        addnewproduct.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PICK_IMAGE_REQUEST
                );
            }
        });
    }
    public double totalprofit(int a, double b){
        return a * b;
    }

    public void savenewProduct(View view){
        e1 = et1.getText().toString();
        e2 = et2.getText().toString();
        try {
            e3 = Integer.parseInt(et3.getText().toString());
        } catch (NumberFormatException e) {
            finish();
            startActivity(getIntent());
            ShowToast st = new ShowToast(getApplicationContext(), "Empty Product Details!!! Try Again");
        }
        e4 = Double.parseDouble(et4.getText().toString());
        e5 = et5.getText().toString();
        e6 = totalprofit(e3,e4);
        Log.d("fi:", String.valueOf(e6));
        byte[] image1 = imageViewToByte(img);
        DBHelperBuddhi dbHelper =  new DBHelperBuddhi(this);
        Log.d("ei:",String.valueOf(e1));
        if(e1.isEmpty()){
            Toast.makeText(this,"Enter Name", Toast.LENGTH_SHORT).show();
        }else{
            dbHelper.addProductShop(e1,e2,e3,e4,e5,image1);
            Intent ordintent = new Intent(this, adminproduct1.class);
            startActivity(ordintent);
            ShowToast st = new ShowToast(getApplicationContext(), "Product Uploaded Successfully");
        }
    }


    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public class ShowToast {
        public ShowToast(Context context, String info) {
            Toast toast = Toast.makeText(context, Html.fromHtml("<font color='#000000' ><b>" + info + "</b></font>"), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PICK_IMAGE_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //gallery intent
                Intent gallertIntent = new Intent(Intent.ACTION_GET_CONTENT);
                gallertIntent.setType("image/*");
                startActivityForResult(gallertIntent, PICK_IMAGE_REQUEST);
            } else {
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
                img.setImageURI(resultUri);
            }else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
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
        Intent ordintent = new Intent(this, adminOrders.class);
        startActivity(ordintent);
    }

}
