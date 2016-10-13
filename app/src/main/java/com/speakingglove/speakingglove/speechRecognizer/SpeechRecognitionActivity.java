package com.speakingglove.speakingglove.speechRecognizer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.speakingglove.speakingglove.Constants;
import com.speakingglove.speakingglove.R;
import com.speakingglove.speakingglove.speechRecognizer.util.ListeningActivity;
import com.speakingglove.speakingglove.speechRecognizer.util.ProcessWords;
import com.speakingglove.speakingglove.speechRecognizer.util.VoiceRecognitionListener;
import com.speakingglove.speakingglove.speechRecognizer.util.WordData;

public class SpeechRecognitionActivity extends ListeningActivity {

    protected Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_recognition);
        context = getApplicationContext(); // Needs to be set

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        VoiceRecognitionListener.getInstance().setListener(this); // Here we set the current listener
        String sessionId = getIntent().getStringExtra("sessionId");
        ProcessWords.setSessionId(sessionId);
        ProcessWords.addWords(Constants.wordList);

        Log.d("Sppech Recognizer", "Started");

        Long tsLong = System.currentTimeMillis() / 1000;
        WordData wordData = new WordData(sessionId, Constants.EVENT_LISTENER_STARTED, 1, ""+tsLong);
        startListening(); // starts listening

        exit = (Button) findViewById(R.id.exitButton);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void processVoiceCommands(String... voiceCommands) {
        if(voiceCommands==null || voiceCommands.length==0){
            return;
        }
        ProcessWords processWords = new ProcessWords(this);
        processWords.execute(voiceCommands);
        restartListeningService();
    }

}
