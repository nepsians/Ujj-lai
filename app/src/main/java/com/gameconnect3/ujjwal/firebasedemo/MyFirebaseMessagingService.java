package com.gameconnect3.ujjwal.firebasedemo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Ujjwal on 10/5/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    MainActivity mainActivity=new MainActivity();
    String TAG = "message";
    ArrayList<String> numberlist=new ArrayList<>();

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...
        Log.d("NIHAL_ONMESSAGERECIE:","123123123132123123123123123123");


        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());


        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            String Message=remoteMessage.getNotification().getBody();
            String number=remoteMessage.getData().get("body");
            Log.d("phone_message: ",Message);
            Log.d("PhoneNumber: ",number);

            try{
                JSONObject jsonObject=new JSONObject(number);
                String msg=jsonObject.getString("message");

                JSONArray array=jsonObject.getJSONArray("numbers");
                for (int i=0; i<array.length();i++){
                    numberlist.add(array.getString(i));
                    Log.d("Number_"+i, (array.getString(i))+"");
                }
            }catch (JSONException e){e.printStackTrace();}



/*
            if(mainActivity.checkingPermission()) {
*/
                for (int j = 0; j < numberlist.size(); j++) {
                    sendMessage(numberlist.get(j),Message);
                }



            /*for (int i=0;i<numberlist.;i++){
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(String.valueOf(numberlist[i]), null, Message, null, null);
                Log.d("Sending Message:","SENDING!!!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }*/
/*
            if(Message.length()>0 && number.length()==10) {
                //Sending Message
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(number, null, Message, null, null);

            }*/


          /*  if (*//* Check if data needs to be processed by long running job *//* true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                scheduleJob();
            } else {
                // Handle message within 10 seconds
                handleNow();
            }*/

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }



        notifyUser(remoteMessage.getFrom(), remoteMessage.getNotification().getBody());

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }


    public void notifyUser(String from, String notification){
        MyNotificationManager myNotificationManager = new MyNotificationManager(getApplicationContext());
        if(SharedPrefManager.getInstance(getApplicationContext()).get_Status()) {
            Log.d("NIHAL:","HDOHFOAHDFOHDFOHAOIDFHOAISHDFIOAHDOIFHADIOFHO");
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("from", from);
            intent.putExtra("message", notification);
            myNotificationManager.showNotification(from, notification, intent);
        }
    }


    public void sendMessage(String phoneNo,String Message){

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNo, null, Message, null, null);
       // Toast.makeText(getApplicationContext(), "Message Sent to "+phoneNo,
         //       Toast.LENGTH_SHORT).show();
       /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

}

