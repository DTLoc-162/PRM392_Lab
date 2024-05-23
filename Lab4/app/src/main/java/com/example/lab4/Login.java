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

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsername, etPassword;
    private Button btnSignIn;
    private final String REQUIRE = "Require";
    private static final String VALID_USERNAME = "thiemloc";
    private static final String VALID_PASSWORD = "123456";

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
        btnSignIn.setOnClickListener(this);

    }
    private boolean checkInput() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if (TextUtils.isEmpty(username)) {
            etUsername.setError(REQUIRE);
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            etPassword.setError(REQUIRE);
            return false;
        }
        if (!username.equals(VALID_USERNAME)) {
            etUsername.setError("Invalid username");
            return false;
        }
        if (!password.equals(VALID_PASSWORD)) {
            etPassword.setError("Invalid password");
            return false;
        }
        return true;
    }
    private void signIn(){
        if(!checkInput()){
            return;
        }
        Toast.makeText(this, "Login Successfully!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnSignIn){
            signIn();
        }
    }
}