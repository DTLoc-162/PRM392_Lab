package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_FOOD = 1;
    private static final int REQUEST_CODE_DRINK = 2;
    private TextView foodTextView, drinkTextView;
    private Button buttonMeal, buttonDrink, buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        foodTextView  = findViewById(R.id.food);
        drinkTextView = findViewById(R.id.drink);
        buttonMeal = findViewById(R.id.buttonMeal);
        buttonDrink = findViewById(R.id.buttonDrink);
        buttonLogout = findViewById(R.id.buttonLogout);

        buttonMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListFood.class);
                startActivityForResult(intent, REQUEST_CODE_FOOD);
            }
        });
        buttonDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListDrink.class);
                startActivityForResult(intent, REQUEST_CODE_DRINK);
            }
        });
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_FOOD) {
                String selectedFood = data.getStringExtra("selectedFood");
                if (selectedFood != null) {
                    foodTextView.setText(selectedFood);
                }
            } else if (requestCode == REQUEST_CODE_DRINK) {
                String selectedDrink = data.getStringExtra("selectedDrink");
                if (selectedDrink != null) {
                    drinkTextView.setText(selectedDrink);
                }
            }
        }
    }
}