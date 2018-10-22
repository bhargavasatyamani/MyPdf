package com.example.bhargav_2.inapppdfdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button genPDFBtn=(Button)findViewById(R.id.genPdfbtn);
        genPDFBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1=new Intent(MainActivity.this,PdfGenerator.class);
                startActivity(intent1);
            }
        });


    }
}
