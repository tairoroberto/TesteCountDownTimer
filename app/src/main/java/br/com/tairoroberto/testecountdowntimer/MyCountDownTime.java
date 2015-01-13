package br.com.tairoroberto.testecountdowntimer;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by tairo on 13/01/15.
 */
public class MyCountDownTime extends CountDownTimer {
    private TextView textView;
    private Context context;
    private long timeFuture;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public MyCountDownTime(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    public MyCountDownTime(Context context,TextView textView, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.context = context;
        this.textView = textView;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        //guarda ao tempo de milisegundos em uma variavel
        timeFuture = millisUntilFinished;
        textView.setText(getCorrectTime(true,millisUntilFinished)+":"+getCorrectTime(false,millisUntilFinished));
    }

    @Override
    public void onFinish() {
        timeFuture -= 1000;
        textView.setText(getCorrectTime(true,timeFuture)+":"+getCorrectTime(false,timeFuture));

        Toast.makeText(context,"FINISH",Toast.LENGTH_SHORT).show();
    }


    private String getCorrectTime(boolean isMinute,long millisUntilFinished){
        String aux;
        int constCalendar = isMinute ? Calendar.MINUTE : Calendar.SECOND;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millisUntilFinished);
        aux = calendar.get(constCalendar) < 10 ? "0"+ calendar.get(constCalendar): ""+ calendar.get(constCalendar);

        return aux;
    }
}
