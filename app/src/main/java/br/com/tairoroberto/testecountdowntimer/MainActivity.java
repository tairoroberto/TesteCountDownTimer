package br.com.tairoroberto.testecountdowntimer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private MyCountDownTime time;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.countDownTimer);
    }

    @Override
    protected void onResume() {
        super.onResume();

        time = new MyCountDownTime(this,textView,5*60*1000,1000);
        time.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (time != null){
            time.cancel();
        }
    }
}
