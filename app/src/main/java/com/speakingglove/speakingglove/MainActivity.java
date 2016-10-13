package com.speakingglove.speakingglove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.speakingglove.speakingglove.speechRecognizer.SpeechRecognitionActivity;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private Button about;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.startButton);
        about = (Button) findViewById(R.id.aboutButton);
        exit = (Button) findViewById(R.id.exitButton);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sppechIntent = new Intent(getApplicationContext(), SpeechRecognitionActivity.class);
                startActivity(sppechIntent);
            }
        });


    }
}
