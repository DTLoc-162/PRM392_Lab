package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class Login extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnSignIn;
    private final String REQUIRE = "REQUIRE";
    private final String usname = "thiemloc";
    private final String password = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                signIn();
            }
        });

    }
    private boolean checkInput() {
        if (TextUtils.isEmpty((etUsername.getText().toString()))) {
            etUsername.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty((etPassword.getText().toString()))) {
            etPassword.setError(REQUIRE);
            return false;
        }
        return true;
    }
    private void signIn() {
        if (!checkInput()) {
            return;
        }
        if (etUsername.getText().toString().trim().equals(usname) && etPassword.getText().toString().trim().equals(password)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            etPassword.setError("Username or password wrong");
        }

    }
}