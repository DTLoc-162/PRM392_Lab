package com.example.lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> courses = new ArrayList<>(Arrays.asList("Android", "PHP", "iOS", "Unity", "ASP.net"));
    ArrayAdapter<String> listAdapter;
    TextView tvheader;
    Button buttonAdd, buttonUpdate;
    EditText InputText;
    ListView lv1;
    int index = -1;
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

        tvheader = findViewById(R.id.tvheader);
        lv1 = findViewById(R.id.lv1);
        buttonAdd = findViewById(R.id.btnAdd);
        buttonUpdate = findViewById(R.id.btnUp);
        InputText = findViewById(R.id.addInput);


        listAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, courses);
        lv1.setAdapter(listAdapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String course = InputText.getText().toString();
                courses.add(course);
                listAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Add a new course successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                InputText.setText(courses.get(position));
                index = position;
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                courses.set(index, InputText.getText().toString());
                listAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Update this course successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String removedCourse = courses.get(position);
                courses.remove(position);
                listAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Delete course: " + removedCourse + " Successfully!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}