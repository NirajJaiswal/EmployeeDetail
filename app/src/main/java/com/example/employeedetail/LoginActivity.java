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

public class LoginActivity extends AppCompatActivity {
    private TextView mEmailTextView;
    private TextView mPasswordTextView;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private TextView mAccountTextView;
    private TextView mSignTextView;
    private Button mLoginButton;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        setValue();


    }

    private void setValue() {
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=mEmailEditText.getText().toString().trim();
                String password=mPasswordEditText.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    mEmailEditText.setError("Enter email");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    mPasswordEditText.setError("Enter password");
                    return;
                }
                if(password.length()<6)
                {
                    mPasswordEditText.setError("Password not less than 6 character");
                    return;
                }
                signUser(email,password);
                progressBar.setVisibility(View.VISIBLE);

            }
        });

        mSignTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initView() {
        mEmailTextView = findViewById(R.id.tv_email);
        mEmailEditText = findViewById(R.id.et_email);
        mPasswordTextView = findViewById(R.id.tv_password);
        mPasswordEditText = findViewById(R.id.et_password);
        mAccountTextView = findViewById(R.id.tv_account);
        mSignTextView = findViewById(R.id.tv_sign);
        mLoginButton = findViewById(R.id.btn_login);
        progressBar=findViewById(R.id.login_progress);
        auth=FirebaseAuth.getInstance();


    }

    private void signUser(String email, String password) {
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),NavigationDrawerActivity.class));
                    finish();
                }
                else
                {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, "No User Found", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        if(user !=null)
        {
            startActivity(new Intent(getApplicationContext(),NavigationDrawerActivity.class));
            finish();
        }
    }
}