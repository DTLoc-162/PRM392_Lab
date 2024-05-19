package com.example.customlistview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView FruitList;
    ArrayList<fruit> arrayFruit;
    fruitAdapter adapter;
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
        Mappings();
        adapter = new fruitAdapter(this, R.layout.activity_fruit, arrayFruit);
        FruitList.setAdapter(adapter);
    }

    private void Mappings() {
        FruitList = findViewById(R.id.FruitList);
        arrayFruit = new ArrayList<>();

        arrayFruit.add(new fruit("Apple", "Apple is a good way to protect your health", R.drawable.apple));
        arrayFruit.add(new fruit("Orange", "Orange is a good way to provide vitamin C", R.drawable.orange));
        arrayFruit.add(new fruit("Strawberry", "Strawberry is a good for your skin", R.drawable.strawberry));
        arrayFruit.add(new fruit("Spicy", "Spicy can make you hot in your health", R.drawable.spicy));
        arrayFruit.add(new fruit("Starfruit", "Starfruit has beautiful view", R.drawable.starfruit));
        arrayFruit.add(new fruit("Banana", "Banana is yellow and good to eat", R.drawable.banana));



    }
}