package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyFourthReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (isOrderedBroadcast()){

            String initData = getResultData();
            int initCode = getResultCode();
            Bundle initBundle = getResultExtras(true);
            String name = initBundle.getString("name");
            int age = initBundle.getInt("age");

            Log.i("af", "Hello from Fourth receiver");
            Toast.makeText(context, "My name is " + name +" and i use " + initData + " because im " + age + " ... " + initCode ,Toast.LENGTH_LONG).show();

        }
    }
}
