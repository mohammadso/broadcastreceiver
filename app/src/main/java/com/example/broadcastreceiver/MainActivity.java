package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MyFirstReceiver myFirstReceiver = new MyFirstReceiver();
//        IntentFilter intent = new IntentFilter();
//        intent.addAction("my.custom.action.name");
//        registerReceiver(myFirstReceiver,intent);

    }

    public void sendBroadcastMessage(View view) {
        Intent intent = new Intent("my.custom.action.name");
        Bundle bundle = new Bundle();
        bundle.putString("name", "mohammad");
        bundle.putInt("age", 22);
        sendOrderedBroadcast(intent,null, new MyFourthReceiver(), null, 11,"IOS", bundle );
    }


    public static class MyThirdReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            if (isOrderedBroadcast()){

                String initData = getResultData();
                int initCode = getResultCode();
                Bundle initBundle = getResultExtras(true);
                String name = initBundle.getString("name");
                int age = initBundle.getInt("age");

                Log.i(TAG, "Hello from Third receiver");
                Toast.makeText(context, "My name is " + name +" and i use " + initData + " because im " + age + " ... " + initCode ,Toast.LENGTH_LONG).show();

                initBundle.putString("name", "sara");
                initBundle.putInt("age", 20);

                setResult(12, "ANDROID", initBundle);
            }


        }
    }
}
