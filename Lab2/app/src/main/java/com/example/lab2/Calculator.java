package com.example.lab2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab2.R;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    EditText editTextN1, editTextN2;
    TextView textView;
    int num1, num2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonAdd = findViewById(R.id.btn_add);
        buttonSub = findViewById(R.id.btn_sub);
        buttonMul = findViewById(R.id.btn_mul);
        buttonDiv = findViewById(R.id.btn_div);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);

    }

    private void passData(){
        Intent intent = new Intent(Calculator.this, PassData.class);
        intent.putExtra("Num1", num1);
        intent.putExtra("Num2", num2);
        startActivity(intent);
    }



    public int getIntFromEditText(EditText editText){
        if(editText.getText().toString().equals("")){
            Toast.makeText(this,"Enter number", Toast.LENGTH_SHORT).show();
            return 0;
        } else
            return Integer.parseInt(editText.getText().toString());
    }
    public void onClick(View view) {
        num1 = getIntFromEditText(editTextN1);
        num2 = getIntFromEditText(editTextN2);

        if (view.getId() == R.id.btn_add) {
            textView.setText(String.valueOf(num1 + num2));
        } else if (view.getId() == R.id.btn_sub) {
            textView.setText(String.valueOf(num1 - num2));
        } else if (view.getId() == R.id.btn_mul) {
            textView.setText(String.valueOf(num1 * num2));
        } else if (view.getId() == R.id.btn_div) {
            if (num2 == 0) {
                textView.setText("Error: Cannot divide by zero");
            } else {
                textView.setText(String.valueOf((float) num1 / num2));
            }
        }
    }
}