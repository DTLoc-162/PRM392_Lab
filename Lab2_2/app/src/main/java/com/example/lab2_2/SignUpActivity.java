package com.example.lab2_2;

import android.annotation.SuppressLint;
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

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private TextView tvAlreadyAccount;
    private Button btnSignUp;

    private final String REQUIRE = "Require";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        tvAlreadyAccount = findViewById(R.id.tvAlreadyAccount);
        btnSignUp = findViewById(R.id.btnSignUp);

        tvAlreadyAccount.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    private boolean checkInput(){
        if(TextUtils.isEmpty(etUsername.getText().toString())){
            etUsername.setError(REQUIRE);
            return false;
        }
        if(TextUtils.isEmpty(etPassword.getText().toString())){
            etPassword.setError(REQUIRE);
            return false;
        }
        if(TextUtils.isEmpty(etConfirmPassword.getText().toString())){
            etConfirmPassword.setError(REQUIRE);
            return false;
        }
        if(!TextUtils.equals(etPassword.getText().toString()
        , etConfirmPassword.getText().toString())){
            Toast.makeText(this, "Password are not match", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void signUp(){
        if(!checkInput()){
            return;
        }
        Toast.makeText(this, "Sign Up successfully!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    private void signInForm(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.btnSignUp:
//                signUp();
//                break;
//            case R.id.tvAlreadyAccount:
//                signInForm();
//                break;
//        }
//    }
    public void onClick(View view){
        if(view.getId() == R.id.btnSignUp){
            signUp();
        }else if(view.getId() == R.id.tvAlreadyAccount){
            signInForm();
        }
    }
}