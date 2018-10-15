package com.gameconnect3.ujjwal.firebasedemo;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;

public class MainActivity extends AppCompatActivity {

    //TopClass topClass;
    ButtomClass buttomClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Log.d("Token---------->>>",SharedPrefManager.getInstance(getApplicationContext()).getToken());
        Log.d("Login_Status: ", String.valueOf(SharedPrefManager.getInstance(getApplicationContext()).get_User_Status()));
        if(SharedPrefManager.getInstance(getApplicationContext()).get_User_Status()){
            startActivity(new Intent(this,SecondMainActivity.class));
        }else {

            //topClass=new TopClass();
            buttomClass = new ButtomClass();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.Buttom_container, buttomClass);
            fragmentTransaction.commit();
        }
    }
    public boolean checkingPermission() {
/*

       int permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS}, 1);

        }
*/

        return true;

    }



}
