package com.example.sqllistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button b2, b3;
    EditText et1, et2;
    DBHandler mydb;
    DataModel usermodel;

    View.OnClickListener clicker = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button2:
                    simpanuser();
                    break;
                case R.id.button3:
                    goToActivity1();
                    break;
            }
        }
    };

    private void goToActivity1(){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
    }

    private void simpanuser(){
        mydb = new DBHandler(this);
        usermodel = new DataModel(1, et1.getText().toString(), et2.getText().toString());
        mydb.insertUser(usermodel);
        Toast tulisan = Toast.makeText(this, "Data Berhasil Disimpan", Toast.LENGTH_LONG);
        tulisan.show();
        et1.setText("");
        et2.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(clicker);

        b3 = findViewById(R.id.button3);
        b3.setOnClickListener(clicker);

        et1 = findViewById(R.id.editTextTextPersonName);
        et2 = findViewById(R.id.editTextTextPersonName2);
    }
}