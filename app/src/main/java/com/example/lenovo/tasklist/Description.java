package com.example.lenovo.tasklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.TextView;

import static com.example.lenovo.tasklist.ListsAdapter.key;

public class Description extends AppCompatActivity {


    TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        desc=(TextView) findViewById(R.id.desc);

        Intent intent = getIntent();
        String message = intent.getStringExtra(key);
        desc.setText(message);
    }
}
