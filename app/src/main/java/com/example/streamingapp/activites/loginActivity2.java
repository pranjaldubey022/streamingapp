package com.example.streamingapp.activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.streamingapp.R;

public class loginActivity2 extends AppCompatActivity {
    private EditText username;private EditText password;
    private Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login2);
        initView();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    private void initView() {
        username = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextTextPassword);
        loginbtn = findViewById(R.id.loginbtn);


        loginbtn.setOnClickListener(v -> {
            if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                startActivity(new Intent(loginActivity2.this, MainActivity.class));
            }
            else if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                username.setError("Required");
                password.setError("Required");
            }
            else{
                username.setError("Invalid");
                password.setError("Invalid");
            }

        });


    }
}