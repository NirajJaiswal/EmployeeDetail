package com.example.employeedetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
private TextView mRegisterName;

    private TextView mRegisterMobile;
    private TextView mRegisterEmail;
    private TextView mRegisterPassword;
    private TextView mRegisterAccount;
    private TextView mRegisterSign;
    private EditText mRegisterNameEditText;
    private EditText mRegisterMobileEditText;
    private EditText mRegisterEmailEditText;
    private EditText mRegisterPasswordEditText;
    private Button mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {

        mRegisterName=findViewById(R.id.tv_name_register);
        mRegisterEmail=findViewById(R.id.tv_name_register);
        mRegisterPassword=findViewById(R.id.tv_password_register);
        mRegisterAccount=findViewById(R.id.tv_account_register);
mRegisterSign=findViewById(R.id.tv_sign_register);
         mRegisterNameEditText=findViewById(R.id.et_name_register);
         mRegisterMobileEditText=findViewById(R.id.et_mobile_no);
         mRegisterEmailEditText=findViewById(R.id.et_email_register);
        mRegisterPasswordEditText=findViewById(R.id.et_password_register);
       mRegisterButton=findViewById(R.id.btn_register);


       mRegisterAccount.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}