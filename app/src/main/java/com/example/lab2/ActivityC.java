package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityC extends AppCompatActivity {

    ImageView imageView;
    TextView tvTotalPrice,tvInstallment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        imageView = findViewById(R.id.imageView);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        tvInstallment  = findViewById(R.id.tvInstallment);

        Intent getData = getIntent();

        Double Total = getData.getDoubleExtra("total", 0);
        Double Installment = getData.getDoubleExtra("installment", 0);

        Long TotalPrice = Math.round(Total);
        Long InstallmentCar = Math.round(Installment);


        tvTotalPrice.setText(String.valueOf("Total Price RM " + TotalPrice));
        tvInstallment.setText(String.valueOf("Installment RM " +InstallmentCar));

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            int img = bundle.getInt("img");
            imageView.setImageResource(img);
        }






}
    //create a method without listener
    public void goToMain(View view){
        //create an object intent
        Intent MainPage = new Intent(this,MainActivity.class);
        startActivity(MainPage);

    }

    public void notify(View view){

        //Displaying Toast with DONE message
        Toast.makeText(getApplicationContext(),"DONE",Toast.LENGTH_SHORT).show();
    }
}

