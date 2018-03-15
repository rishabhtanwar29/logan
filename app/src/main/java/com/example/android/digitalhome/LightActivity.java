package com.example.android.digitalhome;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.jar.JarException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by Rishabh Tanwar on 11/28/2017.
 */

public class LightActivity extends AppCompatActivity {

    private static Bundle bundle = new Bundle();
    ToggleButton ltoggle1;
    ToggleButton ltoggle2;
    ToggleButton ltoggle3;
    ToggleButton ltoggle4;
    ToggleButton ltoggle5;
    ToggleButton ltoggle6;

    SeekBar lseekbar1;
    SeekBar lseekbar2;
    SeekBar lseekbar3;
    SeekBar lseekbar4;
    SeekBar lseekbar5;
    SeekBar lseekbar6;

    Button btnSendHttpRequest;
    OkHttpClient client;
    Request request;

    Boolean myvar1;
    Boolean myvar2;
    Boolean myvar3;
    Boolean myvar4;
    Boolean myvar5;
    Boolean myvar6;
    int progress1=100;
    int progress2=100;
    int progress3=100;
    int progress4=100;
    int progress5=100;
    int progress6=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lightactivity);
        myvar1=bundle.getBoolean("ToggleButtonState1", false);
        myvar2=bundle.getBoolean("ToggleButtonState2", false);
        myvar3=bundle.getBoolean("ToggleButtonState3", false);
        myvar4=bundle.getBoolean("ToggleButtonState4", false);
        myvar5=bundle.getBoolean("ToggleButtonState5", false);
        myvar6=bundle.getBoolean("ToggleButtonState6", false);

        ltoggle1 = (ToggleButton) findViewById(R.id.ltoggleButton1);
        ltoggle2 = (ToggleButton) findViewById(R.id.ltoggleButton2);
        ltoggle3 = (ToggleButton) findViewById(R.id.ltoggleButton3);
        ltoggle4 = (ToggleButton) findViewById(R.id.ltoggleButton4);
        ltoggle5 = (ToggleButton) findViewById(R.id.ltoggleButton5);
        ltoggle6 = (ToggleButton) findViewById(R.id.ltoggleButton6);

        lseekbar1 = (SeekBar) findViewById(R.id.lseekBar1);
        lseekbar2 = (SeekBar) findViewById(R.id.lseekBar2);
        lseekbar3 = (SeekBar) findViewById(R.id.lseekBar3);
        lseekbar4 = (SeekBar) findViewById(R.id.lseekBar4);
        lseekbar5 = (SeekBar) findViewById(R.id.lseekBar5);
        lseekbar6 = (SeekBar) findViewById(R.id.lseekBar6);

        ltoggle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {myvar1 = true;}
                else {myvar1 = false;}
            }
        });
        ltoggle2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {myvar2 = true;}
                else {myvar2 = false;}
            }
        });
        ltoggle3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {myvar3 = true;}
                else {myvar3 = false;}
            }
        });
        ltoggle4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {myvar4 = true;}
                else {myvar4 = false;}
            }
        });
        ltoggle5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {myvar5 = true;}
                else {myvar5 = false;}
            }
        });
        ltoggle6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {myvar6 = true;}
                else {myvar6 = false;}
            }
        });
        lseekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress1=i;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        lseekbar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress2=i;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        lseekbar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress3=i;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        lseekbar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress4=i;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        lseekbar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress5=i;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        lseekbar6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress6=i;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        btnSendHttpRequest = (Button) findViewById(R.id.sendbutton1);
        btnSendHttpRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client = new OkHttpClient();
                myfunction(myvar1, myvar2, myvar3, myvar4, myvar5, myvar6);
            }
        });
    }

    private void myfunction(Boolean lmyvar1, Boolean lmyvar2,Boolean lmyvar3,Boolean lmyvar4,Boolean lmyvar5,Boolean lmyvar6) {

        /**SharedPreferences tokenSharedPreferences=getSharedPreferences("myToken", Context.MODE_PRIVATE);
        String strToken = tokenSharedPreferences.getString("token", null);
        SharedPreferences idSharedPreferences=getSharedPreferences("myId", Context.MODE_PRIVATE);
        String strId = idSharedPreferences.getString("id", null);*/

        MediaType mediaType = MediaType.parse("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
        RequestBody body = RequestBody.create(mediaType,"------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"Item1Bool\"\r\n\r\n"+lmyvar1+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"Item1Value\"\r\n\r\n"+progress1+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"Item2Bool\"\r\n\r\n"+lmyvar2+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"Item2Value\"\r\n\r\n"+progress2+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"Item3Bool\"\r\n\r\n"+lmyvar3+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"Item3Value\"\r\n\r\n"+progress3+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"Item4Bool\"\r\n\r\n"+lmyvar4+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"Item4Value\"\r\n\r\n"+progress4+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"Item5Bool\"\r\n\r\n"+lmyvar5+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"Item5Value\"\r\n\r\n"+progress5+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"Item6Bool\"\r\n\r\n"+lmyvar6+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"Item6Value\"\r\n\r\n"+progress6+"\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--");
        request = new Request.Builder()
                .url("https://home-automation-aries.herokuapp.com/api/update/2/")
                .put(body)
                .addHeader("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
                .addHeader("Authorization", "Token 7675172a4f5fab39a37992885d5e98ac26167ba6")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "c15ae0f5-decd-c961-7e4b-95109a850d6a")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(LightActivity.this, "No internet connection!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                /**String mMessage = response.body().string();*/
                if (response.isSuccessful()) {
                    try {
                        response= client.newCall(request).execute();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        bundle.putBoolean("ToggleButtonState1", ltoggle1.isChecked());
        bundle.putBoolean("ToggleButtonState2", ltoggle2.isChecked());
        bundle.putBoolean("ToggleButtonState3", ltoggle3.isChecked());
        bundle.putBoolean("ToggleButtonState4", ltoggle4.isChecked());
        bundle.putBoolean("ToggleButtonState5", ltoggle5.isChecked());
        bundle.putBoolean("ToggleButtonState6", ltoggle6.isChecked());

        bundle.putInt("SeekBarState1", lseekbar1.getProgress());
        bundle.putInt("SeekBarState2", lseekbar2.getProgress());
        bundle.putInt("SeekBarState3", lseekbar3.getProgress());
        bundle.putInt("SeekBarState4", lseekbar4.getProgress());
        bundle.putInt("SeekBarState5", lseekbar5.getProgress());
        bundle.putInt("SeekBarState6", lseekbar6.getProgress());

    }
    @Override
    public void onResume() {
        super.onResume();
        ltoggle1.setChecked(bundle.getBoolean("ToggleButtonState1", false));
        ltoggle2.setChecked(bundle.getBoolean("ToggleButtonState2", false));
        ltoggle3.setChecked(bundle.getBoolean("ToggleButtonState3", false));
        ltoggle4.setChecked(bundle.getBoolean("ToggleButtonState4", false));
        ltoggle5.setChecked(bundle.getBoolean("ToggleButtonState5", false));
        ltoggle6.setChecked(bundle.getBoolean("ToggleButtonState6", false));

        lseekbar1.setProgress(bundle.getInt("SeekBarState1", 100));
        lseekbar2.setProgress(bundle.getInt("SeekBarState2", 100));
        lseekbar3.setProgress(bundle.getInt("SeekBarState3", 100));
        lseekbar4.setProgress(bundle.getInt("SeekBarState4", 100));
        lseekbar5.setProgress(bundle.getInt("SeekBarState5", 100));
        lseekbar6.setProgress(bundle.getInt("SeekBarState6", 100));
    }
}

