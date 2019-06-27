package com.example.a51006705.senddatafromchildactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText_number1;
    private EditText editText_number2;
    private TextView textView_result;
    private Button button_open_activity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_number1 = findViewById(R.id.edit_text_number1);
        editText_number2 = findViewById(R.id.edit_text_number2);
        textView_result = findViewById(R.id.text_view_result);
        button_open_activity2 = findViewById(R.id.button_open_activity2);
        button_open_activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText_number1.getText().toString().trim().length() == 0 || editText_number2.getText().toString().trim().length() == 0) {
                    Toast.makeText(MainActivity.this, "Please insert numbers", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    int number1 = Integer.parseInt(editText_number1.getText().toString());
                    int number2 = Integer.parseInt(editText_number2.getText().toString());
                    intent.putExtra("number1", number1);
                    intent.putExtra("number2", number2);
                    startActivityForResult(intent, 1);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("result", 0);
                textView_result.setText("" + result);
            } else if (resultCode == RESULT_CANCELED) {
                textView_result.setText("Nothing Selected");
            }
        }
    }
}
