package com.example.bhargav_2.inapppdfdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import com.artifex.mupdf.viewer.DocumentActivity;

public class ViewPDF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);

        startMuPDFActivityWithExample();
        //PDFView pdfView=(PDFView)findViewById(R.id.pdfView);

        //File file=new File(getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),"MyStatement.pdf");
        //pdfView.fromFile(file).load();

    }

    public void startMuPDFActivity(Uri documentUri){
        Intent intent=new Intent(this,DocumentActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(documentUri);
        startActivity(intent);
    }

    public void startMuPDFActivityWithExample(){
        File file=new File(getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),"MyStatement.pdf");
        Uri uri=Uri.fromFile(file);
        startMuPDFActivity(uri);
    }
}
