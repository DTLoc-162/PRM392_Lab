package com.example.lab6_context_menu;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnChonMau;
    ConstraintLayout manHinh;
    @SuppressLint("MissingInflatedId")
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

        btnChonMau = (Button) findViewById(R.id.button_Chonmau);
        manHinh = (ConstraintLayout) findViewById(R.id.manHinh);

        //Đăng ksy view cho context_menu
        registerForContextMenu(btnChonMau);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.menu_context,menu);
        Log.d("MainActivity", "onCreateContextMenu called");
        super.onCreateContextMenu(menu, v, menuInfo);

//        super.onCreateContextMenu(menu, v, menuInfo);
//        Log.d("MainActivity", "onCreateContextMenu called");
//        getMenuInflater().inflate(R.menu.menu_context, menu);
    }


    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menuDo) {
            manHinh.setBackgroundColor(Color.RED);
        } else if (itemId == R.id.menuVang) {
            manHinh.setBackgroundColor(Color.YELLOW);
        } else if (itemId == R.id.menuXanh) {
            manHinh.setBackgroundColor(Color.BLUE);
        }
        Log.d("MainActivity", "onContextItemSelected: " + item.getTitle());
        return super.onContextItemSelected(item);
    }
}