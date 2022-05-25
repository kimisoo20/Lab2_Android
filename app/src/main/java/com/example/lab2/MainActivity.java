package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnEnter;
    EditText txtName;
//    public static final String EXTRA_MESSAGE = "Page Activity B" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set Event Listener on Button Enter
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating string variable t store the value of edit text and convert to string
                String name = txtName.getText().toString();

                //Creating Object goToB from Class Intent & Sent Name input
                Intent gotoB = new Intent(getBaseContext(),ActivityB.class);
                gotoB.putExtra("name",name);
                startActivity(gotoB);
            }
        });
    }

//    /** Called when the user taps the Enter button */
//    public void sendMessage(View view) {
//        Intent intent = new Intent(this, ActivityB.class);
//        EditText editText = (EditText) findViewById(R.id.txtName);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
//    }
}