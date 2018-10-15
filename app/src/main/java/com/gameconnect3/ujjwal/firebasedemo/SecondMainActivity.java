package com.gameconnect3.ujjwal.firebasedemo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class SecondMainActivity extends AppCompatActivity {

    EditText getTopic;
    Button suscribeBtn;
    TextView img1,img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        getTopic=findViewById(R.id.getTopics);
        suscribeBtn=findViewById(R.id.suscribe);
        img1=findViewById(R.id.sim1);
        img2=findViewById(R.id.sim2);


        suscribeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String topics=getTopic.getText().toString();
                if (topics.length()>0){
                    FirebaseMessaging.getInstance().subscribeToTopic(topics);
                    Toast.makeText(SecondMainActivity.this, "Suscribed to topic: "+topics, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), ThirdMainActivity.class));
                    }
                else {
                    getTopic.setError("Please enter the Topic Name");
                }
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ThirdMainActivity.class));
            }
        });

    }


}
