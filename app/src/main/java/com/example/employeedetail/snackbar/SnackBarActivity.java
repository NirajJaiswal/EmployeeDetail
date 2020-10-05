package com.example.employeedetail.snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;

import com.example.employeedetail.R;
import com.google.android.material.snackbar.Snackbar;

public class SnackBarActivity extends AppCompatActivity {
ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);

        constraintLayout=findViewById(R.id.consLayout);
    }

    public void btnHandleSnack(View view) {

        Snackbar snackbar=Snackbar.make(constraintLayout,"hello snack bar",Snackbar.LENGTH_SHORT);
        snackbar.setAction("Show", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar1=Snackbar.make(constraintLayout,"Opps!! ",Snackbar.LENGTH_SHORT);
               snackbar1.show();
            }
        });
        snackbar.show();
    }
}