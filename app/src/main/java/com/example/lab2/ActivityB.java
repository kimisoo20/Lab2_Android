package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    //Declare Object
    float totalPrice , installment;
    TextView textView5;
    RadioButton rdHyundai , rdToyota , rdHonda;
    Button btnCalculate;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

//        // Capture the layout's TextView and set the string as its text
//        TextView textView = findViewById(R.id.textView5);
//        textView.setText(message);

        //link object java to view in XML
        group = findViewById(R.id.radioGroup);
        rdHyundai = findViewById(R.id.rdHyundai);
        rdToyota = findViewById(R.id.rdToyota);
        rdHonda = findViewById(R.id.rdHonda);

        //Create intent object to receive Input Name from Main Activity
        Intent intent = getIntent();
        String text = intent.getStringExtra("name");
        // Set received input to TextView tvName
        textView5.setText(text);

        Intent gotoC = new Intent(this,ActivityC.class);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rdHonda:
                        gotoC.putExtra("img", R.drawable.hondahrv);
                        totalPrice = (float) (145000 + (0.06 * 9 + 145000));
                        installment = totalPrice / 108;
                        break;
                    case R.id.rdToyota:
                        gotoC.putExtra("img", R.drawable.toyotacamry);
                        totalPrice = (float) (170000 + (0.06 * 9 + 170000));
                        installment =totalPrice / 108;
                        break;
                    case R.id.rdHyundai:
                        gotoC.putExtra("img", R.drawable.hyundai);
                        totalPrice = (float) (120000 + (0.06 * 9 + 120000));
                        installment = totalPrice / 108;
                        break;
                }
            }
        });


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoC.putExtra("total",totalPrice);
                gotoC.putExtra("installment",installment);

                startActivity(gotoC);
            }
        });

}


}
