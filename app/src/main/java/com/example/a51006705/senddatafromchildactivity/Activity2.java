package com.example.a51006705.senddatafromchildactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView textView_numbers;
    private Button button_add;
    private Button button_subtract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textView_numbers = findViewById(R.id.text_view_numbers);
        button_add = findViewById(R.id.button_add);
        button_subtract = findViewById(R.id.button_subtract);

        Intent intent = getIntent();
        final int number1 = intent.getIntExtra("number1", 0);
        final int number2 = intent.getIntExtra("number2", 0);

        textView_numbers.setText("Numbers: "+number1+", "+number2);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = number1 + number2;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", result);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        button_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = number1 - number2;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", result);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
