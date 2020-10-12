package com.example.employeedetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
private TextView mEmailTextView;
private TextView mPasswordTextView;
private EditText mEmailEditText;
private  EditText mPasswordEditText;
private TextView mForgotTextView;
private TextView mAccountTextView;
private TextView mSignTextView;
private Button mLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();



    }

    private void initView() {
        mEmailTextView=findViewById(R.id.tv_email);
        mEmailEditText=findViewById(R.id.et_email);
        mPasswordTextView=findViewById(R.id.tv_password);
        mPasswordEditText=findViewById(R.id.et_password);
        mForgotTextView=findViewById(R.id.tv_forgot);
        mAccountTextView=findViewById(R.id.tv_account);
        mSignTextView=findViewById(R.id.tv_sign);
        mLoginButton=findViewById(R.id.btn_login);





        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

       mSignTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
               startActivity(intent);
            }
        });
    }
}