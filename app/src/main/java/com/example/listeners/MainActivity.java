package com.example.listeners;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    Button btnClick;
    Button btnLongClick;
    Button btnTouch;
    Button btnPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        btnClick = findViewById(R.id.btnClick);
        btnLongClick = findViewById(R.id.btnLongClick);
        btnTouch = findViewById(R.id.btnTouch);
        btnPress = findViewById(R.id.btnPress);

        btnClick.setOnClickListener(onClickListener);
        btnLongClick.setOnLongClickListener(onLongClickListener);
        btnTouch.setOnTouchListener(onTouchListener);
        btnPress.setOnTouchListener(onTouchListener);
    }

    View.OnClickListener onClickListener = v -> {
        if (v.getId() == R.id.btnClick) {
            textView.setText("Зафиксирован клик");
        }
    };

    View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if(v.getId() == R.id.btnLongClick) {
                textView.setText("Зафиксировано долгое нажатие кнопки");
            }
            return false;
        }
    };

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (v.getId() == R.id.btnTouch && event.getAction() == MotionEvent.ACTION_MOVE){
                textView.setText(String.format(Locale.ROOT,"x = %.2f\ny = %.2f", event.getX(), event.getY()));
            }

            if (v.getId() == R.id.btnPress && event.getAction() == MotionEvent.ACTION_DOWN) {
                textView.setText("Зафиксировано нажатие");
            }
            return false;
        }
    };
}