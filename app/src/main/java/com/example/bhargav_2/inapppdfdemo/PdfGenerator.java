package com.example.bhargav_2.inapppdfdemo;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfGenerator extends AppCompatActivity {
    LinearLayout myLayout;
    PdfDocument document;
    PdfDocument.PageInfo pageInfo;
    PdfDocument.Page page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_generator);

        myLayout=(LinearLayout)findViewById(R.id.inner_layout);

        ViewTreeObserver vto=myLayout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int width=myLayout.getMeasuredWidth();
                int height=myLayout.getMeasuredHeight();

                document=new PdfDocument();
                pageInfo=new PdfDocument.PageInfo.Builder(width,height,1).create();
                page=document.startPage(pageInfo);
                myLayout.draw(page.getCanvas());
                document.finishPage(page);
                try {
                    File file=new File(getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),"/MyStatement.pdf");
                    FileOutputStream mFileOutStream = new FileOutputStream(file);
                    document.writeTo(mFileOutStream);
                    mFileOutStream.flush();
                    mFileOutStream.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                document.close();
                Intent intent2=new Intent(PdfGenerator.this,ViewPDF.class);
                startActivity(intent2);


            }
        });


    }
}
