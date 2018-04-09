package com.gmail.farasabiyyu12.countdowntimer;

import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private CountDownTimer countDownTimer;
    private boolean timerHasStarted = false;
    private Button btnStart;
    public TextView text;
    private final long startTime = 30 * 1000;
    private final long interval = 1 * 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = this.findViewById(R.id.buttonStart);
        btnStart.setOnClickListener(this);
        text = this.findViewById(R.id.timer);
        countDownTimer = new MyCountDownTimer(startTime, interval);
        text.setText(text.getText() + String.valueOf(startTime / 1000));

    }

    @Override
    public void onClick(View view) {
        if (!timerHasStarted) {
            countDownTimer.start();
            timerHasStarted = true;
            btnStart.setText("STOP");
        } else {
            countDownTimer.cancel();
            timerHasStarted = false;
            btnStart.setText("RESTART");
        }

    }

    private class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }
        @Override
        public void onFinish() {
            text.setText("Time's up!");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            text.setText("" + millisUntilFinished / 1000);
        }

    }
}
