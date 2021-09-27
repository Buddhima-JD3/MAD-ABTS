package com.mad.abts;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mad.abts.database.OrderContract;

public class productdetailscaps extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    // first of all we will get the views that are  present in the layout of info

    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, drinnkName, coffeePrice, totPrice, details;
    Button addtoCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);
        imageView = findViewById(R.id.productimg1);
        plusquantity = findViewById(R.id.productqtyadd);
        minusquantity  = findViewById(R.id.productqtyremove);
        quantitynumber = findViewById(R.id.productqtyN);
        drinnkName = findViewById(R.id.prodname);
        coffeePrice = findViewById(R.id.productprice);
        totPrice = findViewById(R.id.totprice);
        addtoCart = findViewById(R.id.productdetailsbtn);
        details = findViewById(R.id.productdetails);
        Intent prddetintent = getIntent();
        String txt1  = prddetintent.getStringExtra("Extra_Message1");
        double txt2  = Double.parseDouble(prddetintent.getStringExtra("Extra_Message2"));
        String txt3  = prddetintent.getStringExtra("Extra_Message3");

        // setting the name of drink
        drinnkName.setText(txt1);
        coffeePrice.setText("LKR " + String.valueOf(txt2));
        totPrice.setText("Total Price = LKR 000.00");
        details.setText(txt3);

        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productdetailscaps.this, Cart.class);
                startActivity(intent);
                // once this button is clicked we want to save our values in the database and send those values
                // right away to summary activity where we display the order info

                SaveCart();
            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // coffee price
                double basePrice = txt2;
                quantity++;
                displayQuantity();
                double coffePrice = basePrice * quantity;
                String setnewPrice = String.valueOf(coffePrice);
                totPrice.setText("Total Price = LKR " + setnewPrice);
            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double basePrice = txt2;
                // because we dont want the quantity go less than 0
                if (quantity == 0) {
                    Toast.makeText(productdetailscaps.this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    double coffePrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(coffePrice);
                    totPrice.setText("Total Price = LKR " +setnewPrice);


                }
            }
        });



    }

    private boolean SaveCart() {


        // getting the values from our views
        String name = drinnkName.getText().toString();
        String price = coffeePrice.getText().toString();
        String quantity = quantitynumber.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);

        if (mCurrentCartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri==null) {
                Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success  adding to Cart", Toast.LENGTH_SHORT).show();

            }
        }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;

    }



    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,

        };

        return new CursorLoader(this, mCurrentCartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);



            String nameofdrink = cursor.getString(name);
            String priceofdrink = cursor.getString(price);
            String quantityofdrink = cursor.getString(quantity);


            drinnkName.setText(nameofdrink);
            coffeePrice.setText(priceofdrink);
            quantitynumber.setText(quantityofdrink);
        }


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {


        drinnkName.setText("");
        coffeePrice.setText("");
        quantitynumber.setText("");

    }

    public void matches(View view) {
        Intent intent = new Intent(this, matches.class);
        startActivity(intent);
    }
    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void shop(View view) {
        Intent intent = new Intent(this, shop.class);
        startActivity(intent);
    }
    public void teams(View view) {
        Intent intent = new Intent(this, teams.class);
        startActivity(intent);
    }
    public void sidebar(View view) {
        Intent intent = new Intent(this, sidebar.class);
        startActivity(intent);
    }

    public void ADDTOCART(View view){
        int we =  Integer.parseInt(String.valueOf(quantitynumber));
        if(we == 0){
            Toast.makeText(this, "Qty Cannot be Zero", Toast.LENGTH_SHORT).show();
        }else {
            Intent shopintent = new Intent(this, Cart.class);
            startActivity(shopintent);
        }

    }    public void GoRight(View view){
        Intent gorightintent = new Intent(this, myorders.class);
        startActivity(gorightintent);


    }public void GoLeft(View view){
        Intent goleftintent = new Intent(this, shop.class);
        startActivity(goleftintent);
    }

}