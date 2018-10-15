package com.gameconnect3.ujjwal.firebasedemo;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gameconnect3.ujjwal.firebasedemo.ThirdAcitivity.Upper_Log;

public class ThirdMainActivity extends AppCompatActivity {
    Upper_Log upper_log;
    Button logoutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_main);
        logoutbtn=findViewById(R.id.logout);

        upper_log=new Upper_Log();
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.LogContainer,upper_log);
        transaction.commit();

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                Toast.makeText(ThirdMainActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
                SharedPrefManager.getInstance(getApplicationContext()).login_status(false);
                SharedPrefManager.getInstance(getApplicationContext()).User_Login(false);
            }
        });
    }
}
