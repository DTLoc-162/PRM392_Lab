package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListFood extends AppCompatActivity {
    ListView listView;
    ArrayList<Item> arrFood;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_food);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Mappings();
        adapter = new CustomAdapter(this, R.layout.activity_custom_adapter, arrFood);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Item selectedFood = arrFood.get(position);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("selectedFood", selectedFood.getName());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    private void Mappings() {
        listView = findViewById(R.id.FruitList);
        arrFood = new ArrayList<>();

        arrFood.add(new Item("Bún bò", "Good way to protect your health", R.drawable.bunboa));
        arrFood.add(new Item("ComTam", "Orange is a good way to provide vitamin C", R.drawable.bunboa));
        arrFood.add(new Item("Pho", "Strawberry is a good for your skin", R.drawable.bunboa));
        arrFood.add(new Item("Bo lalot", "Spicy can make you hot in your health", R.drawable.bunboa));
        arrFood.add(new Item("Banh uot", "Starfruit has beautiful view", R.drawable.bunboa));
        arrFood.add(new Item("Banh Cuốn", "Banana is yellow and good to eat", R.drawable.bunboa));
    }
}