package com.example.schoolerp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class VerifyOTPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verify_otpactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button button = findViewById(R.id.buttonVerify);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerifyOTPActivity.this, SignupActivity.class);
                startActivity(intent);


                EditText inputCode1 = findViewById(R.id.inputCode1);
                EditText inputCode2 = findViewById(R.id.inputCode2);
                EditText inputCode3 = findViewById(R.id.inputCode3);
                EditText inputCode4 = findViewById(R.id.inputCode4);

                // Set up TextWatcher for each OTP box
                inputCode1.addTextChangedListener(new OTPTextWatcher(inputCode1, inputCode2));
                inputCode2.addTextChangedListener(new OTPTextWatcher(inputCode2, inputCode3));
                inputCode3.addTextChangedListener(new OTPTextWatcher(inputCode3, inputCode4));

                Button buttonSignup = findViewById(R.id.buttonVerify);
                buttonSignup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Your signup logic goes here
                        // For example, starting another activity
                        Intent intent = new Intent(VerifyOTPActivity.this, SignupActivity.class);
                        startActivity(intent);
                    }
                });
            }

            // TextWatcher implementation
            class OTPTextWatcher implements TextWatcher {
                private EditText currentBox;
                private EditText nextBox;

                public OTPTextWatcher(EditText currentBox, EditText nextBox) {
                    this.currentBox = currentBox;
                    this.nextBox = nextBox;
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (s.length() == 1) {
                        // Move focus to the next EditText box
                        nextBox.requestFocus();
                    }
                }
            }


        });
    }
}