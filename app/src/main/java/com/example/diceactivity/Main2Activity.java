package com.example.diceactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import allbegray.slack.SlackClientFactory;
import allbegray.slack.webapi.SlackWebApiClient;
import android.os.Bundle;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    final String slackToken = "xoxp-763082602722-785364129810-812593245186-06d220f8d25bf781fbbee280e63fc1eb";

    SlackWebApiClient mWebApiClient = SlackClientFactory.createWebApiClient(slackToken);

    Button ShareScore = (Button) findViewById(R.id.ShareScore);




    private class SlackAPITake extends AsyncTask<Void, Void, Void>
    {
        protected Void doInBackground (Void... voids) {
            Intent intent2 = getIntent();
            String message = intent2.getStringExtra(MainActivity.EXTRA_MESSAGE);
            mWebApiClient.postMessage("CP4356CUT","Your score is " + message);
            return null;

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }



    public void ShareScore(View v){
        try {
            TextView tv = this.findViewById(R.id.textView);
            enableStrictMode();
            Intent intent2 = getIntent();
            String message = intent2.getStringExtra(MainActivity.EXTRA_MESSAGE);
            tv.setText("your score: " + message + "is shared on Slack!");
            new SlackAPITake().execute();
        }
        catch(Exception ex){
            Toast.makeText(Main2Activity.this, "error server not responding" + ex.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("MainActivity:Error", "Error on button click, see the log", ex);
        }
    }

    private void enableStrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void back (View v){
        Intent BackButton = new Intent (this, MainActivity.class);
        startActivity(BackButton);

    }



}
