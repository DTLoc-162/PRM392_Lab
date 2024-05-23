package com.example.lab5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab5.adapter.UserAdapter;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    ArrayList<User> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        RecyclerView rvUser = findViewById(R.id.rvUser);

        userlist = new ArrayList<>();
        userlist.add(new User("NguyenTT", "Tran Thanh Nguyen", "nguyen@fpt.edu.vn"));
        userlist.add(new User("LocDT", "Dang Thiem Loc", "locdt@fpt.edu.vn"));
        userlist.add(new User("hieudt", "Doan Thanh Hieu", "hieu@fpt.edu.vn"));
        userlist.add(new User("namtpt", "Tran Pham Thanh Nam", "nam@gmail.com"));


        UserAdapter adapter = new UserAdapter(userlist);
//        adapter.notifyDataSetChanged();

        rvUser.setAdapter(adapter);
        rvUser.setLayoutManager(new LinearLayoutManager(this));

    }
}