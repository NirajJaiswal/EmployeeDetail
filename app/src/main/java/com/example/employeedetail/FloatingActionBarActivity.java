package com.example.employeedetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class FloatingActionBarActivity extends AppCompatActivity {
FloatingActionMenu floatingActionMenu;
FloatingActionButton edit,record,photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_bar);
floatingActionMenu=(FloatingActionMenu) findViewById(R.id.floatingActionMenu);
edit=(FloatingActionButton) findViewById(R.id.floatingButtonEdit);
record=(FloatingActionButton) findViewById(R.id.floatingButtonRecord);
photo=(FloatingActionButton) findViewById(R.id.floatingButtonPhoto);

edit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(FloatingActionBarActivity.this,"Edit Clicked",Toast.LENGTH_SHORT).show();
    }
});
record.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(FloatingActionBarActivity.this,"Record Clicked",Toast.LENGTH_SHORT).show();
    }
});
photo.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(FloatingActionBarActivity.this,"Photo Clicked",Toast.LENGTH_SHORT).show();
    }
});

    }
}