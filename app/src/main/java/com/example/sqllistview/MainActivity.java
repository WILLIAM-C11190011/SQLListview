package com.example.sqllistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button b1;
    ListView mylv;
    DBHandler mydb;

    private View.OnClickListener clicker = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button:
                    goToActivity2();
                    break;
            }
        }
    };

    private void goToActivity2() {
            Intent i = new Intent(this, MainActivity2.class);
            startActivity(i);
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DBHandler(this);
        mylv = (ListView) findViewById(R.id.lv1);

        List<ArrayList> data = mydb.getAll();

        CustomAdapter cAdapter = new CustomAdapter(getApplicationContext(), data);
        mylv.setAdapter(cAdapter);

        b1 = findViewById(R.id.button);
        b1.setOnClickListener(clicker);
    }
}