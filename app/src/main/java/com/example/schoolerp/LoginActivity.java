package com.example.schoolerp;

import android.animation.IntArrayEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



        public class LoginActivity extends AppCompatActivity {

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);

                // Call the method to set up button click listeners
                setupButtons();
            }

            private void setupButtons() {
                Button signupButton = findViewById(R.id.Login_button);
                signupButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(LoginActivity.this, SendOTPActivity.class);
                        startActivity(intent);

                    }
                });

                Button forgotPasswordButton = findViewById(R.id.signup);
                forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(LoginActivity.this, VerifyOTPActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }
