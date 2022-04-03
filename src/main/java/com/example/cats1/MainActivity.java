package com.example.cats1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtnAddFrogs(View view) {
        counter++;
        String counter1 = counter.toString();
        TextView counterView = findViewById(R.id.txt_counter);
        counterView.setText(counter1);
        ViewGroup.LayoutParams params = counterView.getLayoutParams();
        params.height += 1;
        params.width += 1;
        counterView.setLayoutParams(params);
        counterView.setText(counter.toString());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        TextView counterView = findViewById(R.id.txt_counter);
        ViewGroup.LayoutParams params = counterView.getLayoutParams();
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        outState.putInt("height", params.height);
        outState.putInt("width", params.width);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        TextView counterView = findViewById(R.id.txt_counter);
        ViewGroup.LayoutParams params = counterView.getLayoutParams();
        counter = savedInstanceState.getInt("counter");
        params.height = savedInstanceState.getInt("height");
        params.width = savedInstanceState.getInt("width");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        ((TextView) findViewById(R.id.txt_counter)).setText(counter.toString());
    }
}

