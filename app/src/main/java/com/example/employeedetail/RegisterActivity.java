package com.example.employeedetail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private TextView mRegisterSign;
    private EditText mRegisterNameEditText;
    private EditText mRegisterMobileEditText;
    private EditText mRegisterEmailEditText;
    private EditText mRegisterPasswordEditText;
    private Button mRegisterButton;
    private ProgressBar mProgressBar;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        setValue();
    }



    private void setValue() {
        mRegisterSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=mRegisterEmailEditText.getText().toString().trim();
                String password=mRegisterPasswordEditText.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    mRegisterEmailEditText.setError("Enter email");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    mRegisterPasswordEditText.setError("Enter password");
                    return;
                }
                if(password.length()<6)
                {
                    mRegisterPasswordEditText.setError("Password not less than 6 character");
                    return;
                }
                registerUser(email,password);
                mProgressBar.setVisibility(View.VISIBLE);



            }
        });
    }

    private void registerUser(String email, final String password) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    mProgressBar.setVisibility(View.GONE);
                    Toast.makeText(RegisterActivity.this, "Successfully register", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),NavigationDrawerActivity.class));
                    finish();
                }
                else
                {
                    mProgressBar.setVisibility(View.GONE);
                    Toast.makeText(RegisterActivity.this, "Some thing went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        mRegisterSign = findViewById(R.id.tv_sign_register);
        mRegisterNameEditText = findViewById(R.id.et_name_register);
        mRegisterMobileEditText = findViewById(R.id.et_mobile_no);
        mRegisterEmailEditText = findViewById(R.id.et_email_register);
        mRegisterPasswordEditText = findViewById(R.id.et_password_register);
        mRegisterButton = findViewById(R.id.btn_register);
        mProgressBar=findViewById(R.id.progress);
        auth=FirebaseAuth.getInstance();

    }
}